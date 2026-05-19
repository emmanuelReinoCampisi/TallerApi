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
@NoArgsConstructor @AllArgsConstructor @Builder
public class DeudaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // vamos a asumir que la deuda recae en una sola cuenta unificada
    @JoinColumn(name = "cliente_id",nullable = false)
    private ClienteEntity cliente;

    @Column(nullable = false)
    BigDecimal dueda;

    @Column(nullable = false)
    LocalDate fechaUltimaActualizacion;

    private LocalDate fechaPagar;
}
