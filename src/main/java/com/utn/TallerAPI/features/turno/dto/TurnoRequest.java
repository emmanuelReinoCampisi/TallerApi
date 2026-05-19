package com.utn.TallerAPI.features.turno.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TurnoRequest(

        Long clienteID,
        @NotNull(message = "El vehiculo es obligatorio")
        Long vehiuculoId,
        @NotNull(message = "La fecha y el horario es necesario")
        LocalDateTime fechaYhoraIngreso,
        LocalDate FechaEntrega,
        String descripcion
) {
}
