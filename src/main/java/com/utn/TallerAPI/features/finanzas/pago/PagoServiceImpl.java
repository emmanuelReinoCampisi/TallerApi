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

    private final PagoRepository pagoRepository;
    private final DeudaRepository deudaRepository;
    private final ClienteRepository clienteRepository;
    private final PagoMapper pagoMapper;

    @Override
    @Transactional
    public PagoResponse registrarPago(PagoRequest request) {

        ClienteEntity c = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro ningun cliente con id: " + request.getClienteId()));

        DeudaEntity deuda = deudaRepository.findByClienteId(c.getId())
                .orElseThrow(() -> new BusinessException("El cliente no posee una cuenta corriente de deuda activa."));

        PagoEntity pago = pagoMapper.toEntity(request);
        pago.setCliente(c);
        pago.setFecha(LocalDateTime.now());

        BigDecimal nuevoSaldo = deuda.getDeuda().subtract(request.getMonto());
        deuda.setDeuda(nuevoSaldo);
        deuda.setFechaUltimaActualizacion(LocalDate.now());

        deudaRepository.save(deuda);
        PagoEntity pagoGuardado = pagoRepository.save(pago);

        return pagoMapper.toResponse(pagoGuardado);
    }

    @Override
    public List<PagoResponse> obtenerPagosPorCliente(Long clienteId) {

        if (!clienteRepository.existsById(clienteId)) {
            throw new ResourceNotFoundException("Cliente no encontrado");
        }

        return pagoRepository.findByClienteId(clienteId).stream()
                .map(pagoMapper::toResponse)
                .collect(Collectors.toList());
    }
}