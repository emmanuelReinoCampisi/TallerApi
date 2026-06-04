package com.utn.TallerAPI.features.cliente.mapper;

import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.cliente.dto.ClienteRequest;
import com.utn.TallerAPI.features.cliente.dto.ClienteResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {

    public ClienteEntity toEntity(ClienteRequest request) {
        if (request == null) { return null; }

        ClienteEntity cliente = new ClienteEntity();
        cliente.setTipoCliente(request.getTipoCliente());
        return cliente;
    }

    public ClienteResponse toResponse(ClienteEntity cliente) {
        if (cliente == null) { return null; }

        ClienteResponse response = new ClienteResponse();
        response.setUsuarioID(cliente.getId());
        response.setTipoCliente(cliente.getTipoCliente());
        return response;
    }
}