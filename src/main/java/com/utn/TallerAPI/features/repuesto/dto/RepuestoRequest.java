package com.utn.TallerAPI.features.repuesto.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record RepuestoRequest (

        @NotBlank(message = "El codigo de repuesto es obligatorio")
        String codigoRepuesto,

        @NotBlank(message = "El nombre del repuesto es obligatorio")
        String nombreRepuesto,

        @NotNull(message = "El precio de COSTO es obligatorio")
        @Positive(message = "El precio debe ser mayor a 0")
        BigDecimal precioCosto,

        @NotNull(message = "El precio de VENTA es obligatorio")
        @Positive(message = "El precio debe ser mayor a 0")
        BigDecimal precioVenta,

        @NotNull(message = "El stock actual es obligatorio")
        @Min(value = 0, message = "El stock no puede ser negativo")
        Integer stockActual,

        @NotNull(message = "El stock mínimo es obligatorio")
        @Min(value = 0, message = "El stock mínimo no puede ser negativo")
        Integer stockMinimo


){
}
