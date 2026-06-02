package com.utn.TallerAPI.features.finanzas.pago.mapper;

import com.utn.TallerAPI.features.finanzas.pago.PagoEntity;
import com.utn.TallerAPI.features.finanzas.pago.dto.PagoRequest;
import com.utn.TallerAPI.features.finanzas.pago.dto.PagoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PagoMapper {

    public PagoEntity toEntity(PagoRequest request) {
        if (request == null) { return null; }

        PagoEntity pago = new PagoEntity();
        pago.setMontoPagar(request.getMonto());
        pago.setFecha(request.getFechaPago());
        return pago;
    }

    public PagoResponse toResponse(PagoEntity pago) {
        if (pago == null) { return null; }

        PagoResponse response = new PagoResponse();
        response.setIdPago(pago.getIdPago());
        response.setMonto(pago.getMontoPagar());
        response.setFechaPago(pago.getFecha());
        if (pago.getOrdenTrabajo() != null) {
            response.setOrdenTrabajoId(pago.getOrdenTrabajo().getId());
        }
        return response;
    }
}