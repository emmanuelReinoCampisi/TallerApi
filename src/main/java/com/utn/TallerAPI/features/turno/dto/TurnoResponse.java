package com.utn.TallerAPI.features.turno.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TurnoResponse(

        Long id,
        Long clienteId,
        String NombreCliente,
        Long vehiculoId,
        String patenteVehiculo,
        LocalDateTime fechaYhoraIngreso,
        LocalDate fechaEntrega,
        String estado,
        String descripcion,
        String creadoPor

) {
}
