package com.utn.TallerAPI.features.orden.mapper;

import com.utn.TallerAPI.features.orden.DetalleOrden;
import com.utn.TallerAPI.features.orden.dto.DetalleOrdenResponse;
import org.mapstruct.Mapping;

import java.util.List;

public interface DetalleOrdenMapper {

    @Mapping(target = "repuestoId", source = "repuesto.id")
    @Mapping(target = "nombreRepuesto", source = "repuesto.nombre")
    DetalleOrdenResponse toResponse(DetalleOrden detalleOrden);

    List<DetalleOrdenResponse> toResponseList(List<DetalleOrden> detalles);
}
