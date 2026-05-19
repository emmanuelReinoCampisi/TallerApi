package com.utn.TallerAPI.features.cliente.mapper;

import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.cliente.dto.ClienteRequest;
import com.utn.TallerAPI.features.cliente.dto.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "id",ignore = true)
    ClienteEntity toEntity(ClienteRequest request);

    @Mapping(source = "usuario.id", target = "usuarioId")
    ClienteResponse toResponse(ClienteEntity cliente);
}
