package com.utn.TallerAPI.features.vehiculo;

public record VehiculoDTO(
        Long id,
        String patente,
        String marca,
        String modelo,
        String dueñoNombre
) {}

