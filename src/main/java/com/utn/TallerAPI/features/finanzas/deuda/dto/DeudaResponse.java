package com.utn.TallerAPI.features.finanzas.deuda.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DeudaResponse {

    private Long idDeuda;
    private BigDecimal montoTotal;
    private BigDecimal saldoDeudor;
    private LocalDate ultimaActualizacion;

    public DeudaResponse() {
    }

    public Long getIdDeuda() { return idDeuda; }
    public void setIdDeuda(Long idDeuda) { this.idDeuda = idDeuda; }

    public BigDecimal getMontoTotal() { return montoTotal; }
    public void setMontoTotal(BigDecimal montoTotal) { this.montoTotal = montoTotal; }

    public BigDecimal getSaldoDeudor() { return saldoDeudor; }
    public void setSaldoDeudor(BigDecimal saldoDeudor) { this.saldoDeudor = saldoDeudor; }

    public LocalDate getUltimaActualizacion() { return ultimaActualizacion; }
    public void setUltimaActualizacion(LocalDate ultimaActualizacion) { this.ultimaActualizacion = ultimaActualizacion; }
}