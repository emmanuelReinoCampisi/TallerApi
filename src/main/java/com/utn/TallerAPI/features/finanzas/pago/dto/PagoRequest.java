package com.utn.TallerAPI.features.finanzas.pago.dto;

import com.utn.TallerAPI.features.finanzas.pago.TipoPago;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PagoRequest(

        @NotNull(message = "El ID del cliente es obligatorio")
        Long clienteId,

        Long ordenTrabajoId, // por si paga un orden en especifico

        @NotNull(message = "El monto es obligatorio")
        @Positive(message = "El monto debe ser mayor a cero")
        BigDecimal montoPagar,

        @NotNull(message = "El método de pago es obligatorio")
        TipoPago metodoPago

        //String comprobante a chequear


) {
}
