package com.utn.TallerAPI.features.orden.dto;

public class OrdenMecanicoResponse {

    private String mecanicoNombre;
    private String especialidadNombre;

    public OrdenMecanicoResponse() {
    }

    public String getMecanicoNombre() { return mecanicoNombre; }
    public void setMecanicoNombre(String mecanicoNombre) { this.mecanicoNombre = mecanicoNombre; }

    public String getEspecialidadNombre() { return especialidadNombre; }
    public void setEspecialidadNombre(String especialidadNombre) { this.especialidadNombre = especialidadNombre; }
}