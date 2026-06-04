package com.utn.TallerAPI.features.finanzas.deuda;


import com.utn.TallerAPI.features.cliente.ClienteEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "deuda_cliente")
@NoArgsConstructor @AllArgsConstructor @Builder
public class DeudaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // vamos a asumir que la deuda recae en una sola cuenta unificada
    @JoinColumn(name = "cliente_id",nullable = false)
    private ClienteEntity cliente;

    @Column(nullable = false)
    private BigDecimal dueda;

    @Column(nullable = false)
    private LocalDate fechaUltimaActualizacion;

    private LocalDate fechaPagar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getDueda() {
        return dueda;
    }

    public void setDueda(BigDecimal dueda) {
        this.dueda = dueda;
    }

    public LocalDate getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(LocalDate fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public LocalDate getFechaPagar() {
        return fechaPagar;
    }

    public void setFechaPagar(LocalDate fechaPagar) {
        this.fechaPagar = fechaPagar;
    }
}
