package com.utn.TallerAPI.features.orden.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DetalleOrdenRequest (
        Long repuestoId,
        @NotBlank(message = "La descripcion del trabajo es obligatoria")
        String descripcionTrabajo,
        Integer cantidad,
        @NotNull(message = "El precio unitario es obligatorio")
        BigDecimal precioUnitario

){}
