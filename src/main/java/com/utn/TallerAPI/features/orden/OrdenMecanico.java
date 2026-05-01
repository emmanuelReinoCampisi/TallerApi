package com.utn.TallerAPI.features.orden;

import com.utn.TallerAPI.features.mecanico.Especialidad;
import com.utn.TallerAPI.features.mecanico.MecanicoEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orden_mecanico")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class OrdenMecanico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id")
    private OrdenTrabajo orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mecanico_id")
    private MecanicoEntity mecanico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;
}