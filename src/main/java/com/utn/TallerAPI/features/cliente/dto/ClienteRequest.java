package com.utn.TallerAPI.features.cliente.dto;

import jakarta.validation.constraints.NotNull;

public record ClienteRequest(

        @NotNull(message = "el campo no puede ser nulo")
        Long usuarioId,
        @NotNull(message = "tipo de cliente es necesario")
        String tipoCliente
) {
}
