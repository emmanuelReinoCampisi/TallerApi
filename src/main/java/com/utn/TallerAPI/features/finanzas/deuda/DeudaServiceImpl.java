package com.utn.TallerAPI.features.finanzas.deuda;

import com.utn.TallerAPI.Exception.ResourceNotFoundException;
import com.utn.TallerAPI.features.cliente.ClienteRepository;
import com.utn.TallerAPI.features.finanzas.deuda.dto.DeudaRequest;
import com.utn.TallerAPI.features.finanzas.deuda.dto.DeudaResponse;
import com.utn.TallerAPI.features.finanzas.deuda.mapper.DeudaMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DeudaServiceImpl implements DeudaService {

    private final DeudaRepository deudaRepository;
    private final ClienteRepository clienteRepository;
    private final DeudaMapper deudaMapper;


    @Override
    public DeudaResponse obtenerPorClienteId(Long clienteId) {

        if (!clienteRepository.existsById(clienteId)) {
            throw new ResourceNotFoundException("No se encontro deuda del cliente con ID: " + clienteId);
        }

        DeudaEntity deuda = deudaRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro una cuenta con deuda activa"));

        return deudaMapper.toResponse(deuda);
    }

    @Override
    @Transactional
    public DeudaResponse ajustarDeudaManualmente(DeudaRequest request) {

        DeudaEntity deuda = deudaRepository.findByClienteId(request.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("No se encuentra una cuenta con deuda para el cliente con el ID: " + request.getClienteId()));

        deuda.setDeuda(request.getSaldoDeudor());
        deuda.setFechaPagar(request.getFechaPagar());
        deuda.setFechaUltimaActualizacion(LocalDate.now());
        return deudaMapper.toResponse(deudaRepository.save(deuda));
    }
}