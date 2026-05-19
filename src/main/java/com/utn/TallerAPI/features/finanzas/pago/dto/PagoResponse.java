package com.utn.TallerAPI.features.finanzas.pago.dto;

import com.utn.TallerAPI.features.finanzas.pago.TipoPago;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PagoResponse(

        Long idPago,
        Long clienteId,
        Long ordenTrabajoId,
        LocalDate fecha,
        BigDecimal montoPagar,
        TipoPago metodoPago,
        String comprobante
) {
}
