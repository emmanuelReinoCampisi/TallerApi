package com.utn.TallerAPI.features.finanzas.pago.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoRequest {

        @NotNull(message = "El monto del pago es obligatorio")
        @Positive(message = "El monto debe ser mayor a cero")
        private Double monto;

        @NotNull(message = "La fecha de pago es obligatoria")
        private LocalDateTime fechaPago;

        @NotNull(message = "El ID de la orden de trabajo es obligatorio")
        private Long ordenTrabajoId;

        @NotNull(message = "El ID del cliente es obligatorio")
        private Long clienteId;

        public PagoRequest() {
        }

        public BigDecimal getMonto() { return monto; }
        public void setMonto(Double monto) { this.monto = monto; }

        public LocalDateTime getFechaPago() { return fechaPago; }
        public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }

        public Long getOrdenTrabajoId() { return ordenTrabajoId; }
        public void setOrdenTrabajoId(Long ordenTrabajoId) { this.ordenTrabajoId = ordenTrabajoId; }

        public Long getClienteId() { return clienteId; }
        public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
}