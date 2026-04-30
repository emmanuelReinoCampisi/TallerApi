package com.utn.TallerAPI.features.Mecanico.DTO;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record MecanicoRequest(Long usuarioId,
                              @NotBlank String legajo,
                              BigDecimal sueldo,
                              LocalDate fechaIngreso,
                              List<Long> especialidadIds) {
}
