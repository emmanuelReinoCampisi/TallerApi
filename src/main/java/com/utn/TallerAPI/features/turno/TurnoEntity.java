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

@NoArgsConstructor
@AllArgsConstructor
public class TurnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private Long clienteId;
    @NotBlank
    private String nombreCliente;
    @NotBlank
    private Long vehiculoId;
    @NotBlank
    private String patenteVehiculo;
    @NotBlank
    private String marca;
    @NotBlank
    private LocalDateTime fechaYhoraIngreso;
    @NotBlank
    private LocalDateTime fechaYhoraSalida;
    @NotBlank
    private EstadoTurno estado;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "creado_por_id")
    private UsuarioEntity creadoPor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Long getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Long vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getPatenteVehiculo() {
        return patenteVehiculo;
    }

    public void setPatenteVehiculo(String patenteVehiculo) {
        this.patenteVehiculo = patenteVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDateTime getFechaYhoraIngreso() {
        return fechaYhoraIngreso;
    }

    public void setFechaYhoraIngreso(LocalDateTime fechaYhoraIngreso) {
        this.fechaYhoraIngreso = fechaYhoraIngreso;
    }

    public LocalDateTime getFechaYhoraSalida() {
        return fechaYhoraSalida;
    }

    public void setFechaYhoraSalida(LocalDateTime fechaYhoraSalida) {
        this.fechaYhoraSalida = fechaYhoraSalida;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    public UsuarioEntity getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(UsuarioEntity creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
