package com.utn.TallerAPI.features.turno;

import com.utn.TallerAPI.features.usuario.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    Long clienteId;
    @NotBlank
    String nombreCliente;
    @NotBlank
    Long vehiculoId;
    @NotBlank
    String patenteVehiculo;
    @NotBlank
    String marca;
    @NotBlank
    LocalDateTime fechaYhoraIngreso;
    @NotBlank
    LocalDateTime fechaYhoraSalida;
    @NotBlank
    EstadoTurno estado;
    String descripcion;

    @ManyToOne
    @JoinColumn(name = "creado_por_id")
    UsuarioEntity creadoPor;
}
