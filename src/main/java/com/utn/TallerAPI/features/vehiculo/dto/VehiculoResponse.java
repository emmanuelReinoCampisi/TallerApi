package com.utn.TallerAPI.features.vehiculo.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehiculoResponse{

    private Long id;
    private Long clienteId;
    private  String nombreCliente;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private Integer kilometraje;
    private  String estadoEnTaller;
    private   boolean esPropio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstadoEnTaller() {
        return estadoEnTaller;
    }

    public void setEstadoEnTaller(String estadoEnTaller) {
        this.estadoEnTaller = estadoEnTaller;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    public boolean isEsPropio() {
        return esPropio;
    }

    public void setEsPropio(boolean esPropio) {
        this.esPropio = esPropio;
    }
}
