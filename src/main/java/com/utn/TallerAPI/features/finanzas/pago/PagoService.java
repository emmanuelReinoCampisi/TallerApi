package com.utn.TallerAPI.features.finanzas.pago;

import com.utn.TallerAPI.features.finanzas.pago.dto.PagoRequest;
import com.utn.TallerAPI.features.finanzas.pago.dto.PagoResponse;

import java.util.List;

public interface PagoService {
    PagoResponse registrarPago(PagoRequest request);
    List<PagoResponse> obtenerPagosPorCliente(Long clienteId);
}
