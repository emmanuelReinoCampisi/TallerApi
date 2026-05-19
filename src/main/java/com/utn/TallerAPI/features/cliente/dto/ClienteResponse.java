package com.utn.TallerAPI.features.cliente.dto;

public record ClienteResponse(

        Long clienteId,
        Long usuarioID,
        String tipoCliente

) {
}
