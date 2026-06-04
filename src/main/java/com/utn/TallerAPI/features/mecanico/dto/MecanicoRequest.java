package com.utn.TallerAPI.features.mecanico.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MecanicoRequest{
    private Long usuarioId;
                              @NotBlank private String legajo;
    private BigDecimal sueldo;
    private  LocalDate fechaIngreso;
    private   List<Long> especialidadIds;


    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Long> getEspecialidadIds() {
        return especialidadIds;
    }

    public void setEspecialidadIds(List<Long> especialidadIds) {
        this.especialidadIds = especialidadIds;
    }
}
