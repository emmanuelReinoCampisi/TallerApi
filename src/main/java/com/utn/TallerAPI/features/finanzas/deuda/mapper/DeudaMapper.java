package com.utn.TallerAPI.features.finanzas.deuda.mapper;

import com.utn.TallerAPI.features.finanzas.deuda.DeudaEntity;
import com.utn.TallerAPI.features.finanzas.deuda.dto.DeudaRequest;
import com.utn.TallerAPI.features.finanzas.deuda.dto.DeudaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class DeudaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "fechaUltimaActualizacion", ignore = true)
    @Mapping(target = "deuda", source = "saldoDeudor")
    public abstract DeudaEntity toEntity(DeudaRequest request);

    @Mapping(target = "idDeuda", source = "id")
    @Mapping(target = "montoTotal", source = "deuda")
    @Mapping(target = "saldoDeudor", source = "deuda")
    @Mapping(target = "ultimaActualizacion", source = "fechaUltimaActualizacion")
    public abstract DeudaResponse toResponse(DeudaEntity deuda);
}