package com.utn.TallerAPI.features.vehiculo.dto;

import com.utn.TallerAPI.features.vehiculo.EstadoVehiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VehiculoRequest(

        Long clienteId,
        @NotBlank
        @Pattern(regexp = "^[A-Z]{2}\\d{3}[A-Z]{2}$|^[A-Z]{3}\\d{3}$",
                message = "Formato de patente inválido. Ej: ABC123 o AB123CD")
        String patente,
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        Integer anio,
        String color,
        Integer kilometraje,
        EstadoVehiculo estadoVehiculo,
        boolean esPropio

) {
}
