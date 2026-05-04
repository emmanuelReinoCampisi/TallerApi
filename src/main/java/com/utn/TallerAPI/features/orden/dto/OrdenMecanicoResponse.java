package com.utn.TallerAPI.features.orden.dto;

public record OrdenMecanicoResponse (

        Long id,
        String mecanicoNombre,
        String especialidadNombre,
        String observaciones

) {
}
