package com.utn.TallerAPI.features.orden;

import com.utn.TallerAPI.features.turno.TurnoEntity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ordenes_trabajo")
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "turno_id")
    private TurnoEntity turno;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoOrden estado; // Cambiá 'EstadoOrden' por el nombre exacto de tu Enum de estados


    @OneToMany(mappedBy = "ordenTrabajo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleOrden> detalles;


    @OneToMany(mappedBy = "ordenTrabajo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenMecanico> mecanicos;

    // Constructor vacío obligatorio para JPA
    public OrdenTrabajo() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TurnoEntity getTurno() {
        return turno;
    }

    public void setTurno(TurnoEntity turno) {
        this.turno = turno;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public List<DetalleOrden> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleOrden> detalles) {
        this.detalles = detalles;
    }

    public List<OrdenMecanico> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(List<OrdenMecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }
}