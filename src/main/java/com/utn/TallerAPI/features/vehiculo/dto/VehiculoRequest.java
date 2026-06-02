package com.utn.TallerAPI.features.vehiculo.dto;

import com.utn.TallerAPI.features.vehiculo.EstadoVehiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoRequest{

        private Long clienteId;
        @NotBlank
        @Pattern(regexp = "^[A-Z]{2}\\d{3}[A-Z]{2}$|^[A-Z]{3}\\d{3}$",
                message = "Formato de patente inválido. Ej: ABC123 o AB123CD")
       private String patente;
        @NotBlank
        private String marca;
        @NotBlank
        private String modelo;
    private Integer anio;
    private String color;
    private Integer kilometraje;
    private  EstadoVehiculo estadoVehiculo;
    private boolean esPropio;

    public boolean isEsPropio() {
        return esPropio;
    }

    public void setEsPropio(boolean esPropio) {
        this.esPropio = esPropio;
    }

    public EstadoVehiculo getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(EstadoVehiculo estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
