package com.utn.TallerAPI.features.Mecanico;

import com.utn.TallerAPI.features.Orden.OrdenMecanico;
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
}
