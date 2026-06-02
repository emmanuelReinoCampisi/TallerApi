package com.utn.TallerAPI.features.orden.mapper;

import com.utn.TallerAPI.features.orden.DetalleOrden; // Ajustá el import a tu Entidad de detalle
import com.utn.TallerAPI.features.orden.dto.DetalleOrdenResponse;
import org.mapstruct.Mapper;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DetalleOrdenMapper {

    public DetalleOrdenResponse toResponse(DetalleOrden detalle) {
        if (detalle == null) { return null; }

        DetalleOrdenResponse response = new DetalleOrdenResponse();
        response.setId(detalle.getId());
        response.setDescripcion(detalle.getDescripcionTrabajo());
        response.setCantidad(detalle.getCantidad());
        response.setPrecioUnitario(detalle.getPrecioUnitario());

        // Calculamos el subtotal sobre la marcha de manera segura
        if (detalle.getCantidad() != null && detalle.getPrecioUnitario() != null) {
            response.setSubtotal(detalle.getCantidad() * detalle.getPrecioUnitario());
        }

        return response;
    }

    public List<DetalleOrdenResponse> toResponseList(List<DetalleOrden> detalles) {
        if (detalles == null) { return null; }
        List<DetalleOrdenResponse> lista = new ArrayList<>();
        for (DetalleOrden d : detalles) {
            lista.add(this.toResponse(d));
        }
        return lista;
    }
}