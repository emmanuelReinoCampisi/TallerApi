package com.utn.TallerAPI.features.Usuario.Mapper;

import com.utn.TallerAPI.features.Usuario.DTO.UsuarioRequest;
import com.utn.TallerAPI.features.Usuario.DTO.UsuarioResponse;
import com.utn.TallerAPI.features.Usuario.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {


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
