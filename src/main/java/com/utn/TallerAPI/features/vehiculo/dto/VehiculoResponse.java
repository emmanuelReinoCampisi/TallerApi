package com.utn.TallerAPI.features.vehiculo.dto;

public record VehiculoResponse(

        Long id,
        Long clienteId,
        String nombreCliente,
        String patente,
        String marca,
        String modelo,
        Integer anio,
        String color,
        Integer kilometraje,
        String estadoEnTaller,
        boolean esPropio

) {
}
