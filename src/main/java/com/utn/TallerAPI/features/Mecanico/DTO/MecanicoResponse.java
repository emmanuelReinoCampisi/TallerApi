package com.utn.TallerAPI.features.Mecanico.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record MecanicoResponse(Long id, Long usuarioId, String nombre,
                               String apellido, String legajo, BigDecimal sueldo,
                               LocalDate fechaIngreso, boolean activo,
                               List<EspecialidadResponse> especialidades) {

}
