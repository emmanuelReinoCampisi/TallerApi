package com.utn.TallerAPI.features.orden.dto;

import java.util.List;

public class OrdenResponse {

    private Long id;
    private Long turnoId;
    private String vehiculoPatente;
    private String clienteNombre;
    private String estado;
    private List<DetalleOrdenResponse> detalles;
    private List<OrdenMecanicoResponse> mecanicos;

    public OrdenResponse() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTurnoId() { return turnoId; }
    public void setTurnoId(Long turnoId) { this.turnoId = turnoId; }

    public String getVehiculoPatente() { return vehiculoPatente; }
    public void setVehiculoPatente(String vehiculoPatente) { this.vehiculoPatente = vehiculoPatente; }

    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public List<DetalleOrdenResponse> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleOrdenResponse> detalles) { this.detalles = detalles; }

    public List<OrdenMecanicoResponse> getMecanicos() { return mecanicos; }
    public void setMecanicos(List<OrdenMecanicoResponse> mecanicos) { this.mecanicos = mecanicos; }
}