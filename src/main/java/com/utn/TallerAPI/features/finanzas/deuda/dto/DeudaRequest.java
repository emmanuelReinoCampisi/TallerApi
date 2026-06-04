package com.utn.TallerAPI.features.finanzas.deuda.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class DeudaRequest {

        @NotNull(message = "El monto total es obligatorio")
        @PositiveOrZero(message = "El monto total no puede ser negativo")
        private Double montoTotal;

        @NotNull(message = "El saldo deudor es obligatorio")
        @PositiveOrZero(message = "El saldo deudor no puede ser negativo")
        private Double saldoDeudor;

        @NotNull(message = "El ID del cliente es obligatorio")
        private Long clienteId;

        public DeudaRequest() {
        }

        public Double getMontoTotal() { return montoTotal; }
        public void setMontoTotal(Double montoTotal) { this.montoTotal = montoTotal; }

        public Double getSaldoDeudor() { return saldoDeudor; }
        public void setSaldoDeudor(Double saldoDeudor) { this.saldoDeudor = saldoDeudor; }

        public Long getClienteId() { return clienteId; }
        public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
}