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
}
