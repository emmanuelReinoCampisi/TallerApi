package com.utn.TallerAPI.features.Usuario;

import com.utn.TallerAPI.features.Usuario.DTO.UsuarioRequest;
import com.utn.TallerAPI.features.Usuario.DTO.UsuarioResponse;

import java.util.List;

public interface IusuarioService {
    UsuarioResponse crearUsuario(UsuarioRequest usuarioRequest);
    UsuarioResponse obtenerPorId(Long Id);
    List<UsuarioResponse> obtenerTodosUsuarios();
    UsuarioResponse actualizarUsuario(Long id,UsuarioRequest usuarioRequest);
    void eliminarUsuario(Long id);

}
