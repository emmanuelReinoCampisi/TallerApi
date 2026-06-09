package com.utn.TallerAPI.features.cliente.dto;

import com.utn.TallerAPI.features.cliente.TipoCliente;
import jakarta.validation.constraints.NotNull;

public record ClienteRequest(

        @NotNull(message = "el campo no puede ser nulo")
        Long usuarioId,
        @NotNull(message = "tipo de cliente es necesario")
        TipoCliente tipoCliente
) {
}
