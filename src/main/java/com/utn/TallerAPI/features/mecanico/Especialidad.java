package com.utn.TallerAPI.features.mecanico;

import com.utn.TallerAPI.features.orden.OrdenMecanico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "especialidades")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String nombreEspecialidad;

    @ManyToMany(mappedBy = "especialidades", fetch = FetchType.LAZY)
    private List<MecanicoEntity> mecanicos;

    @OneToMany(mappedBy = "especialidad", fetch = FetchType.LAZY)
    private List<OrdenMecanico> ordenesMecanico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MecanicoEntity> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(List<MecanicoEntity> mecanicos) {
        this.mecanicos = mecanicos;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public List<OrdenMecanico> getOrdenesMecanico() {
        return ordenesMecanico;
    }

    public void setOrdenesMecanico(List<OrdenMecanico> ordenesMecanico) {
        this.ordenesMecanico = ordenesMecanico;
    }
}
