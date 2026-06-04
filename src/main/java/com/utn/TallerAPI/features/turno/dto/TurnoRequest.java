package com.utn.TallerAPI.features.turno.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurnoRequest{

        private Long clienteID;
        @NotNull(message = "El vehiculo es obligatorio")
        private  Long vehiuculoId;
        @NotNull(message = "La fecha y el horario es necesario")
        private  LocalDateTime fechaYhoraIngreso;
        private  LocalDate FechaEntrega;
        private String descripcion;


        public Long getClienteID() {
                return clienteID;
        }

        public void setClienteID(Long clienteID) {
                this.clienteID = clienteID;
        }

        public Long getVehiuculoId() {
                return vehiuculoId;
        }

        public void setVehiuculoId(Long vehiuculoId) {
                this.vehiuculoId = vehiuculoId;
        }

        public LocalDateTime getFechaYhoraIngreso() {
                return fechaYhoraIngreso;
        }

        public void setFechaYhoraIngreso(LocalDateTime fechaYhoraIngreso) {
                this.fechaYhoraIngreso = fechaYhoraIngreso;
        }

        public LocalDate getFechaEntrega() {
                return FechaEntrega;
        }

        public void setFechaEntrega(LocalDate fechaEntrega) {
                FechaEntrega = fechaEntrega;
        }

        public String getDescripcion() {
                return descripcion;
        }

        public void setDescripcion(String descripcion) {
                this.descripcion = descripcion;
        }
}
