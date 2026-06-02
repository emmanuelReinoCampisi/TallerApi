package com.utn.TallerAPI.features.finanzas.pago;

import com.utn.TallerAPI.Exception.BusinessException;
import com.utn.TallerAPI.Exception.ResourceNotFoundException;
import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.cliente.ClienteRepository;
import com.utn.TallerAPI.features.finanzas.deuda.DeudaEntity;
import com.utn.TallerAPI.features.finanzas.deuda.DeudaRepository;
import com.utn.TallerAPI.features.finanzas.pago.dto.PagoRequest;
import com.utn.TallerAPI.features.finanzas.pago.dto.PagoResponse;
import com.utn.TallerAPI.features.finanzas.pago.mapper.PagoMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {

    private  PagoRepository pagoRepository;
    private  DeudaRepository deudaRepository;
    private  ClienteRepository clienteRepository;
    private  PagoMapper pagoMapper;

    @Override
    @Transactional
    public PagoResponse registrarPago(PagoRequest request) {

        // me fijo que el cliente exista
        ClienteEntity c = clienteRepository.findById(Math.toIntExact(request.clienteId())).orElseThrow(()-> new ResourceNotFoundException("No se encontro ningun cliente con id: "+request.clienteId()));

        // que tenga una cuenta que tenga deuda activa
        DeudaEntity deuda = deudaRepository.findByClienteId(c.getId())
                .orElseThrow(() -> new BusinessException("El cliente no posee una cuenta corriente de deuda activa."));

        // mapeo el dto a entity
        PagoEntity pago = pagoMapper.toEntity(request);
        pago.setCliente(c);
        pago.setFecha(LocalDateTime.now());


        // a futuro se puede buscar y settear la orden del trabajo

        // actualizo la deuda, resto el monto pagado por la deuda del cliente
        BigDecimal nuevoSaldo = deuda.getDueda().subtract(request.montoPagar());
        deuda.setDueda(nuevoSaldo);
        deuda.setFechaUltimaActualizacion(LocalDate.now());

        // persisto los cambios
        deudaRepository.save(deuda);
        PagoEntity pagoGuardado = pagoRepository.save(pago);

        // devuelvo el nuevo DTO
        return  pagoMapper.toResponse(pagoGuardado);
    }

    @Override
    public List<PagoResponse> obtenerPagosPorCliente(Long clienteId) {

        if(!clienteRepository.existsByUsuarioId(clienteId)){
            throw new ResourceNotFoundException("Cliente no encontrado");
        }

        return  pagoRepository.findByClienteId(clienteId).stream()
                .map(pagoMapper :: toResponse)
                .collect(Collectors.toList());

    }
}
