package com.utn.TallerAPI.features.turno;

import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.usuario.UsuarioEntity;
import com.utn.TallerAPI.features.vehiculo.VehiculoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TurnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo_id")
    private VehiculoEntity vehiculo;

    private LocalDateTime fechaYhoraIngreso;
    private LocalDateTime fechaYhoraSalida;
    private EstadoTurno estado;
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creado_por_id")
    private UsuarioEntity creadoPor;
}
