package com.utn.TallerAPI.features.finanzas.deuda.mapper;

import com.utn.TallerAPI.features.finanzas.deuda.DeudaEntity;
import com.utn.TallerAPI.features.finanzas.deuda.dto.DeudaRequest;
import com.utn.TallerAPI.features.finanzas.deuda.dto.DeudaResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DeudaMapper {

    public DeudaEntity toEntity(DeudaRequest request) {
        if (request == null) { return null; }

        DeudaEntity deuda = new DeudaEntity();
        deuda.setMontoTotal(request.getMontoTotal());
        deuda.setSaldoDeudor(request.getSaldoDeudor());
        return deuda;
    }

    public DeudaResponse toResponse(DeudaEntity deuda) {
        if (deuda == null) { return null; }

        DeudaResponse response = new DeudaResponse();
        response.setIdDeuda(deuda.getIdDeuda());
        response.setMontoTotal(deuda.getMontoTotal());
        response.setSaldoDeudor(deuda.getSaldoDeudor());
        response.setUltimaActualizacion(deuda.getUltimaActualizacion());
        return response;
    }
}