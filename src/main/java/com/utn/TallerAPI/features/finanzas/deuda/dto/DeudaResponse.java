package com.utn.TallerAPI.features.finanzas.deuda.dto;

import java.time.LocalDateTime;

public class DeudaResponse {

    private Long idDeuda;
    private Double montoTotal;
    private Double saldoDeudor;
    private LocalDateTime ultimaActualizacion;

    public DeudaResponse() {
    }

    public Long getIdDeuda() { return idDeuda; }
    public void setIdDeuda(Long idDeuda) { this.idDeuda = idDeuda; }

    public Double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(Double montoTotal) { this.montoTotal = montoTotal; }

    public Double getSaldoDeudor() { return saldoDeudor; }
    public void setSaldoDeudor(Double saldoDeudor) { this.saldoDeudor = saldoDeudor; }

    public LocalDateTime getUltimaActualizacion() { return ultimaActualizacion; }
    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) { this.ultimaActualizacion = ultimaActualizacion; }
}