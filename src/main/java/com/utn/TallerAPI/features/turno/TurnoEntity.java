package com.utn.TallerAPI.features.turno;

import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.usuario.UsuarioEntity;
import com.utn.TallerAPI.features.vehiculo.VehiculoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TurnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    @NotNull
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo_id", nullable = false)
    @NotNull
    private VehiculoEntity vehiculo;

    @NotNull
    @Column(name = "fecha_hora_ingreso", nullable = false)
    private LocalDateTime fechaYhoraIngreso;

    @Column(name = "fecha_hora_salida")
    private LocalDateTime fechaYhoraSalida;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoTurno estado;

    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creado_por_id")
    private UsuarioEntity creadoPor;
}