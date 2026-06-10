package com.utn.TallerAPI.features.usuario.dto;

import com.utn.TallerAPI.features.usuario.Rol;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioResponse {

    private Long id;
    private String username;
    private String email;
    private String nombre;
    private String apellido;
    private Long dni;
    private String telefono;
    private Rol rol;
    private boolean activo;
}