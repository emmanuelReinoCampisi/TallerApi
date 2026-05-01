package com.utn.TallerAPI.features.mecanico.dto;

import jakarta.validation.constraints.NotBlank;

public record EspecialidadRequest(@NotBlank String nombre, String descripcion) {
}
