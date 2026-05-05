package com.utn.TallerAPI.features.orden.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record OrdenResponse (
        Long id,
        Long turnoId,
        String vehiculoPatente,
        String clienteNombre,
        LocalDate fechaApertura,
        LocalDate fechaCierre,
        String diagnostico,
        String estado,
        BigDecimal subtotal,
        BigDecimal descuento,
        BigDecimal total,
        boolean pagada,
        List<DetalleOrdenResponse> detalles,
        List<OrdenMecanicoResponse> mecanicos
){
}
