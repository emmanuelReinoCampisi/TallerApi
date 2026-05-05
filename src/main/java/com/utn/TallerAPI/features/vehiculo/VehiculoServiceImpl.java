package com.utn.TallerAPI.features.vehiculo;

import com.utn.TallerAPI.Exception.BusinessException;
import com.utn.TallerAPI.Exception.ResourceNotFoundException;
import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoRequest;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoResponse;
import com.utn.TallerAPI.features.vehiculo.mapper.VehiculoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService{

    private final VehiculoRepository vehiculoRepository;
// falta ClienteRepository
    private final VehiculoMapper vehiculoMapper;
/*
    @Override
    @Transactional
    public VehiculoResponse crear(VehiculoRequest request) {
        String patenteLimpia = request.patente().trim().toUpperCase();
        if (vehiculoRepository.existsByPatente(patenteLimpia)) {
            throw new BusinessException("Ya existe un vehículo registrado con la patente: " + patenteLimpia);
        }

        VehiculoEntity vehiculo = vehiculoMapper.toEntity(request);
        vehiculo.setPatente(patenteLimpia); // Seteamos la patente ya normalizada

        if (request.clienteId() != null) {
            ClienteEntity cliente = clienteRepository.findById(request.clienteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + request.clienteId()));
            vehiculo.setCliente(cliente);
        }

        if (vehiculo.getKilometraje() == null) vehiculo.setKilometraje(0);

        if (vehiculo.getEstado() == null) {
            vehiculo.setEstado(EstadoVehiculo.DISPONIBLE);
        }

        return vehiculoMapper.toResponse(vehiculoRepository.save(vehiculo));
    }
*/
    @Override
    public VehiculoResponse obtenerPorId(Long id) {
        VehiculoEntity vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado con ID: " + id));
        return vehiculoMapper.toResponse(vehiculo);
    }

    @Override
    public Page<VehiculoResponse> listarTodos(Pageable pageable) {
        return vehiculoRepository.findAll(pageable).map(vehiculoMapper::toResponse);
    }

    @Override
    public List<VehiculoResponse> listarPorCliente(Long clienteId) {
        return vehiculoMapper.toResponseList(vehiculoRepository.findByClienteId(clienteId));
    }

    @Override
    @Transactional
    public VehiculoResponse actualizar(String patente, VehiculoRequest request) {
        VehiculoEntity vehiculo = vehiculoRepository.findByPatenteId(patente).orElseThrow(()-> new ResourceNotFoundException("Vehiculo no encontrado: " + patente));
        if (!vehiculo.getPatente().equals(request.patente().toUpperCase())
                && vehiculoRepository.existsByPatente(request.patente().toUpperCase())) {
            throw new BusinessException("Ya existe un vehículo con la patente: " + request.patente());
        }

        vehiculo.setPatente(request.patente().toUpperCase());
        vehiculo.setMarca(request.marca());
        vehiculo.setModelo(request.modelo());
        vehiculo.setAnio(request.anio());
        vehiculo.setColor(request.color());
        vehiculo.setKilometraje(request.kilometraje());
        return vehiculoMapper.toResponse(vehiculoRepository.save(vehiculo));
    }

    @Override
    @Transactional
    public VehiculoResponse actualizarEstado(Long id, EstadoVehiculo nuevoEstado) {

        VehiculoEntity v = vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el vehículo con ID: " + id));
        v.setEstado(nuevoEstado);
        return vehiculoMapper.toResponse(vehiculoRepository.save(v));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!vehiculoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehículo no encontrado con id: " + id);
        }
        vehiculoRepository.deleteById(id);
    }



}



