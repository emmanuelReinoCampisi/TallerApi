package com.utn.TallerAPI.features.orden.dto;

import com.utn.TallerAPI.features.orden.EstadoOrden;
import jakarta.validation.constraints.NotNull;

public record CambioEstadoRequest (
    @NotNull(message = "El estado es obligatorio")
    EstadoOrden nuevoEstado
){}
