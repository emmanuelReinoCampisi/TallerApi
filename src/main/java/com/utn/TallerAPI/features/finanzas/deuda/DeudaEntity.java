package com.utn.TallerAPI.features.finanzas.deuda;

import com.utn.TallerAPI.features.cliente.ClienteEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "deuda_cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeudaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @Column(nullable = false)
    private BigDecimal deuda;

    @Column(nullable = false)
    private LocalDate fechaUltimaActualizacion;

    private LocalDate fechaPagar;
}