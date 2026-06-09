package com.utn.TallerAPI.features.orden;

import com.utn.TallerAPI.features.repuesto.RepuestoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_orden")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id", nullable = false)
    private OrdenTrabajo orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repuesto_id")
    private RepuestoEntity repuesto;

    @NotBlank
    @Column(nullable = false)
    private String descripcionTrabajo;

    @Column(nullable = false)
    private Integer cantidad = 1;

    @NotNull
    @Column(nullable = false)
    private BigDecimal precioUnitario;
}