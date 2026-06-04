package com.utn.TallerAPI.features.cliente.dto;

import com.utn.TallerAPI.features.cliente.TipoCliente;
import jakarta.validation.constraints.NotNull;

public class ClienteRequest{

        @NotNull(message = "el campo no puede ser nulo")
        Long usuarioId;
        @NotNull(message = "tipo de cliente es necesario")
        TipoCliente tipoCliente;


    public Long getUsuarioId() {
        return usuarioId;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
}
