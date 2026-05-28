package com.utn.TallerAPI.features.finanzas.pago.mapper;

import com.utn.TallerAPI.features.finanzas.pago.PagoEntity;
import com.utn.TallerAPI.features.finanzas.pago.dto.PagoRequest;
import com.utn.TallerAPI.features.finanzas.pago.dto.PagoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface PagoMapper {

    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "ordenTrabajo", ignore = true)
    @Mapping(target = "idPago", ignore = true)
    @Mapping(target = "fecha", ignore = true)
    PagoEntity toEntity(PagoRequest request);


    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "ordenTrabajo.id", target = "ordenTrabajoId")
    PagoResponse toResponse(PagoEntity pago);
}
