package com.utn.TallerAPI.features.finanzas.pago.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponse {

    private Long idPago;
    private Double monto;
    private LocalDateTime fechaPago;
    private Long ordenTrabajoId;

    public PagoResponse() {
    }

    public Long getIdPago() { return idPago; }
    public void setIdPago(Long idPago) { this.idPago = idPago; }

    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }

    public LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }

    public Long getOrdenTrabajoId() { return ordenTrabajoId; }
    public void setOrdenTrabajoId(Long ordenTrabajoId) { this.ordenTrabajoId = ordenTrabajoId; }
}