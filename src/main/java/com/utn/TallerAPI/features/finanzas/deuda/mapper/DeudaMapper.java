package com.utn.TallerAPI.features.finanzas.deuda.mapper;

import com.utn.TallerAPI.features.finanzas.deuda.DeudaEntity;
import com.utn.TallerAPI.features.finanzas.deuda.dto.DeudaRequest;
import com.utn.TallerAPI.features.finanzas.deuda.dto.DeudaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface DeudaMapper {
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ultimaActualizacion", ignore = true)
    DeudaEntity toEntity(DeudaRequest request);

    @Mapping(source = "cliente.id", target = "clienteId")
    DeudaResponse toResponse(DeudaEntity deuda);
}
