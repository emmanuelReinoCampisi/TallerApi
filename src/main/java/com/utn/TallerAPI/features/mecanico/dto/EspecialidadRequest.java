package com.utn.TallerAPI.features.mecanico.dto;

import jakarta.validation.constraints.NotBlank;

public class EspecialidadRequest{
    @NotBlank private String nombre;
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
