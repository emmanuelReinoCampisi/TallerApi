package com.utn.TallerAPI.features.finanzas.deuda.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DeudaRequest(

        @NotNull(message = "El ID del cliente es obligatorio")
        Long clienteId,

        @NotNull(message = "El saldo deudor es obligatorio")
        BigDecimal saldoDeudor,

        LocalDate fechaPagar


) {
}
