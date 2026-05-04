package com.utn.TallerAPI.features.orden.dto;

import jakarta.validation.constraints.NotNull;

public record OrdenMecanicoRequest(
        @NotNull(message = "El mecanico es obligatorio")
        Long mecanicoId,
        @NotNull(message = "La especialidad es obligatoria")
        Long especialidadId,
        String observaciones

) {
}
