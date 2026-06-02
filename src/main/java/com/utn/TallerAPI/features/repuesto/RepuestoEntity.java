package com.utn.TallerAPI.features.repuesto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "repuesto")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepuestoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigoRepuesto;


    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @Column(nullable = false)
    private BigDecimal precioCosto;

    @Column(nullable = false)
    private BigDecimal precioVenta;

    @Column(nullable = false)
    private Integer stockActual;

    @Column(nullable = false)
    private Integer stockMinimo; // tirar alerta cuando hay poco stock

public boolean isBajoStoc(){

    return this.stockActual <= this.stockMinimo;
}

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoRepuesto() {
        return codigoRepuesto;
    }

    public void setCodigoRepuesto(String codigoRepuesto) {
        this.codigoRepuesto = codigoRepuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(BigDecimal precioCosto) {
        this.precioCosto = precioCosto;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
}
