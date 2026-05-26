package com.utn.TallerAPI.features.finanzas.deuda.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DeudaResponse(


        Long id,
        Long clienteId,
        BigDecimal saldoDeudor,
        LocalDate ultimaActualizacion,
        LocalDate fechaPagar

) {
}
