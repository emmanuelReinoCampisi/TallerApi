package com.utn.TallerAPI.features.cliente.mapper;

import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.cliente.dto.ClienteRequest;
import com.utn.TallerAPI.features.cliente.dto.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "tipoCliente", source = "tipoCliente")
    ClienteEntity toEntity(ClienteRequest request);

    @Mapping(target = "clienteId", source = "id")
    @Mapping(target = "usuarioID", source = "usuario.id")
    @Mapping(target = "tipoCliente", expression = "java(cliente.getTipoCliente() != null ? cliente.getTipoCliente().name() : null)")
    ClienteResponse toResponse(ClienteEntity cliente);
}