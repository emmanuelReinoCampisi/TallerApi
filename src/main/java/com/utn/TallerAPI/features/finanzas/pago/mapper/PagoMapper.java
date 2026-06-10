package com.utn.TallerAPI.features.finanzas.pago.mapper;

import com.utn.TallerAPI.features.finanzas.pago.PagoEntity;
import com.utn.TallerAPI.features.finanzas.pago.dto.PagoRequest;
import com.utn.TallerAPI.features.finanzas.pago.dto.PagoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PagoMapper {

    @Mapping(target = "idPago", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "ordenTrabajo", ignore = true)
    @Mapping(target = "fecha", ignore = true)
    @Mapping(target = "metodoPago", ignore = true)
    public abstract PagoEntity toEntity(PagoRequest request);

    @Mapping(target = "idPago", source = "idPago")
    @Mapping(target = "monto", source = "montoPagar")
    @Mapping(target = "fechaPago", source = "fecha")
    @Mapping(target = "ordenTrabajoId", source = "ordenTrabajo.id")
    public abstract PagoResponse toResponse(PagoEntity pago);
}