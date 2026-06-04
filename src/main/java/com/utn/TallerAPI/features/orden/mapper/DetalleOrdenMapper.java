package com.utn.TallerAPI.features.orden.mapper;

import com.utn.TallerAPI.features.orden.DetalleOrden;
import com.utn.TallerAPI.features.orden.dto.DetalleOrdenResponse;
import org.mapstruct.Mapper;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DetalleOrdenMapper {

    public DetalleOrdenResponse toResponse(DetalleOrden detalleOrden) {
        if (detalleOrden == null) { return null; }

        DetalleOrdenResponse response = new DetalleOrdenResponse();
        response.setId(detalleOrden.getId());
        response.setCantidad(detalleOrden.getCantidad());
        response.setPrecioUnitario(detalleOrden.getPrecioUnitario());


        if (detalleOrden.getRepuesto() != null) {
            response.setRepuestoId(detalleOrden.getRepuesto().getId());
            response.setNombreRepuesto(detalleOrden.getRepuesto().getNombre());
        }

        return response;
    }

    public List<DetalleOrdenResponse> toResponseList(List<DetalleOrden> detalles) {
        if (detalles == null) { return null; }

        List<DetalleOrdenResponse> list = new ArrayList<>();
        for (DetalleOrden detalle : detalles) {
            list.add(toResponse(detalle));
        }
        return list;
    }
}