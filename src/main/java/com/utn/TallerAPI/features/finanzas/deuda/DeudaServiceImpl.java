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
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeudaServiceImpl implements DeudaService {

    private DeudaRepository deudaRepository;
    private ClienteRepository clienteRepository;
    private DeudaMapper deudaMapper;


    @Override
    public DeudaResponse obtenerPorClienteId(Integer clienteId) {

        if(!clienteRepository.existsById(clienteId)){
            throw new ResourceNotFoundException("No se encontro deuda del cliente con ID: "+clienteId);
        }

        DeudaEntity deuda = deudaRepository.findById(clienteId).orElseThrow(() -> new ResourceNotFoundException("No se encontro una cuenta con deuda activa"));

        return deudaMapper.toResponse(deuda);
    }

    @Override
    @Transactional
    public DeudaResponse ajustarDeudaManualmente(DeudaRequest request) {

        DeudaEntity deuda = deudaRepository.findByClienteId(request.clienteId()).orElseThrow(()-> new ResourceNotFoundException("No se encuentra una cuenta con deuda para el cliente con el ID: "+request.clienteId()));

        deuda.setDueda(request.saldoDeudor());
        deuda.setFechaPagar(request.fechaPagar());
        deuda.setFechaUltimaActualizacion(LocalDate.now());
        return deudaMapper.toResponse(deudaRepository.save(deuda));
    }
}
