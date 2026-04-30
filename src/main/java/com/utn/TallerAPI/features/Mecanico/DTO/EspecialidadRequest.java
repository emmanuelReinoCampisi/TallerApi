package com.utn.TallerAPI.features.Mecanico.DTO;

import jakarta.validation.constraints.NotBlank;

public record EspecialidadRequest(@NotBlank String nombre, String descripcion) {
}
