package com.utn.TallerAPI.features.usuario;

import com.utn.TallerAPI.features.usuario.dto.UsuarioRequest;
import com.utn.TallerAPI.features.usuario.dto.UsuarioResponse;

import java.util.List;

public interface IusuarioService {
    UsuarioResponse crearUsuario(UsuarioRequest usuarioRequest);
    UsuarioResponse obtenerPorId(Long Id);
    List<UsuarioResponse> obtenerTodosUsuarios();
    UsuarioResponse actualizarUsuario(Long id,UsuarioRequest usuarioRequest);
    void eliminarUsuario(Long id);

}
