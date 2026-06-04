package com.utn.TallerAPI.features.mecanico;


import com.utn.TallerAPI.features.orden.OrdenMecanico;
import com.utn.TallerAPI.features.usuario.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="mecanicos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MecanicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) @NotBlank
    private String legajo;

    private BigDecimal salario;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Builder.Default
    private boolean activo = true;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id",unique = true)
    private UsuarioEntity usuario;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "mecanico_especialidad", joinColumns = @JoinColumn(name = "mecanico_id"),inverseJoinColumns = @JoinColumn(name = "especialidad_id"))
    private List<Especialidad> especialidades;

    @OneToMany(mappedBy = "mecanico",fetch = FetchType.LAZY)
    private List<OrdenMecanico> ordenes;


    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public List<OrdenMecanico> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<OrdenMecanico> ordenes) {
        this.ordenes = ordenes;
    }
}
