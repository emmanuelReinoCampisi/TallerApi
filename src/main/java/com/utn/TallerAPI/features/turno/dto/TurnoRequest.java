package com.utn.TallerAPI.features.turno.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurnoRequest {

    private Long clienteId;

    @NotNull(message = "El vehiculo es obligatorio")
    private Long vehiculoId;

    @NotNull(message = "La fecha y el horario es necesario")
    private LocalDateTime fechaYhoraIngreso;

    private LocalDate fechaEntrega;

    private String descripcion;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Long vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public LocalDateTime getFechaYhoraIngreso() {
        return fechaYhoraIngreso;
    }

    public void setFechaYhoraIngreso(LocalDateTime fechaYhoraIngreso) {
        this.fechaYhoraIngreso = fechaYhoraIngreso;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}