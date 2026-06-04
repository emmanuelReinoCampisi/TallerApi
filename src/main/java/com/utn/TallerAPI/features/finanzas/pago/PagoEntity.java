package com.utn.TallerAPI.features.finanzas.pago;


import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.orden.OrdenTrabajo;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
@NoArgsConstructor @AllArgsConstructor
@Builder
public class PagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "orden_trabajo_id")
    private OrdenTrabajo ordenTrabajo; // Puede ser null si paga "a cuenta" y no una orden específica

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private BigDecimal montoPagar;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPago metodoPago;

   // private String comprobante; // Corregido el typo "comporobante" del UML


    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(BigDecimal montoPagar) {
        this.montoPagar = montoPagar;
    }

    public Long getIdPago() {
        return idPago;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }
}
