package com.utn.TallerAPI.features.orden.dto;

import java.math.BigDecimal;

public record DetalleOrdenResponse (

        Long id,
        Long repuestoId,
        String nombreRepuesto,
        String descripcionTrabajo,
        Integer cantidad,
        BigDecimal precioUnitario

){}
