package com.utn.TallerAPI.features.finanzas.deuda.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class DeudaRequest {

    @NotNull(message = "El monto total es obligatorio")
    @PositiveOrZero(message = "El monto total no puede ser negativo")
    private BigDecimal montoTotal;

    @NotNull(message = "El saldo deudor es obligatorio")
    @PositiveOrZero(message = "El saldo deudor no puede ser negativo")
    private BigDecimal saldoDeudor;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;

    private java.time.LocalDate fechaPagar;

    public DeudaRequest() {
    }

    public BigDecimal getMontoTotal() { return montoTotal; }
    public void setMontoTotal(BigDecimal montoTotal) { this.montoTotal = montoTotal; }

    public BigDecimal getSaldoDeudor() { return saldoDeudor; }
    public void setSaldoDeudor(BigDecimal saldoDeudor) { this.saldoDeudor = saldoDeudor; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public java.time.LocalDate getFechaPagar() { return fechaPagar; }
    public void setFechaPagar(java.time.LocalDate fechaPagar) { this.fechaPagar = fechaPagar; }
}