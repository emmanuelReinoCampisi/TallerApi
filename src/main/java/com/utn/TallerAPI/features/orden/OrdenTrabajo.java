package com.utn.TallerAPI.features.orden;

import com.utn.TallerAPI.features.turno.*;
import com.utn.TallerAPI.features.turno.TurnoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordenes_trabajo")
@Getter @Setter
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_apertura")
    private LocalDate fechaApertura;

    @Column(name = "fecha_cierre")
    private LocalDate fechaCierre;

    @Column(columnDefinition = "TEXT")
    private String diagnostico;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoOrden estado;

    private Double subtotal;
    private Double descuento;
    private Double total;

    private boolean pagada;


    @OneToOne
    @JoinColumn(name = "turno_id", referencedColumnName = "id")
    private TurnoEntity turno;


    @OneToMany(mappedBy = "ordenTrabajo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleOrden> detalles = new ArrayList<>();
}