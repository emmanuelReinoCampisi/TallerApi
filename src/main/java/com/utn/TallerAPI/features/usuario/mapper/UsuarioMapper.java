package com.utn.TallerAPI.features.usuario.mapper;

import com.utn.TallerAPI.features.usuario.dto.UsuarioRequest;
import com.utn.TallerAPI.features.usuario.dto.UsuarioResponse;
import com.utn.TallerAPI.features.usuario.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "password", ignore = true),
        @Mapping(target = "activo", ignore = true),
        @Mapping(target = "fechaCreacion", ignore = true),
        @Mapping(target = "mecanico", ignore = true),
        @Mapping(target = "clienteEntity", ignore = true),
        @Mapping(target = "userName", source = "username")
    })
    UsuarioEntity toEntity(UsuarioRequest request);

    void updateEntity(@MappingTarget UsuarioEntity entity, UsuarioRequest request);

    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "username", source = "userName")
    })
    UsuarioResponse toResponse(UsuarioEntity entity);

    List<UsuarioResponse> toResponseList(List<UsuarioEntity> entities);
}