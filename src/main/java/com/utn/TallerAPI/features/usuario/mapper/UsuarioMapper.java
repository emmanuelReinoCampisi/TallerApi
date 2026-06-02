package com.utn.TallerAPI.features.usuario.mapper;

import com.utn.TallerAPI.features.usuario.dto.UsuarioRequest;
import com.utn.TallerAPI.features.usuario.dto.UsuarioResponse;
import com.utn.TallerAPI.features.usuario.UsuarioEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {


    public UsuarioEntity toEntity(UsuarioRequest request){

        if(request == null)return null;
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUserName(request.getUsername());
        usuario.setPassword(request.getPassword());
        usuario.setEmail(request.getEmail());
        return usuario;
    }

    public UsuarioResponse toResponse(UsuarioEntity entity){

        if(entity == null)return null;
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setId(entity.getId());
        usuarioResponse.setUsername(entity.getUserName());
        usuarioResponse.setEmail(entity.getEmail());
        return usuarioResponse;
    }


}
