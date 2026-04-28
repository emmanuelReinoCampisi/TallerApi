package com.utn.TallerAPI.features.Mecanico;


import com.utn.TallerAPI.features.Orden.OrdenMecanico;
import com.utn.TallerAPI.features.Usuario.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="mecanicos")
@Getter
@Setter
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



}
