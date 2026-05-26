package com.utn.TallerAPI.features.repuesto.dto;


import java.math.BigDecimal;

public record RepuestoResponse(

         Long id,

 String codigoRepuesto,


 String nombre,

 String descripcion,

 BigDecimal precioCosto,

 BigDecimal precioVenta,

 Integer stockActual,

 Integer stockMinimo,

   boolean bajoStock
) {
}
