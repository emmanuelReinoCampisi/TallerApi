package com.utn.TallerAPI.features.Vehiculo;

public record VehiculoDTO(
        Long id,
        String patente,
        String marca,
        String modelo,
        String dueñoNombre
) {}

