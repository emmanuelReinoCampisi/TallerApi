package com.utn.TallerAPI.features.repuesto.mapper;

import com.utn.TallerAPI.features.repuesto.RepuestoEntity;
import com.utn.TallerAPI.features.repuesto.dto.RepuestoRequest;
import com.utn.TallerAPI.features.repuesto.dto.RepuestoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RepuestoMapper {

    public RepuestoEntity toEntity(RepuestoRequest request) {
        if (request == null) { return null; }

        RepuestoEntity repuesto = new RepuestoEntity();
        repuesto.setNombre(request.getNombreRepuesto());
        repuesto.setCodigoRepuesto(request.getCodigoRepuesto());
        repuesto.setStockActual(request.getStockActual());
        repuesto.setStockMinimo(request.getStockMinimo());
        repuesto.setPrecioVenta(request.getPrecioVenta());
        return repuesto;
    }

    public RepuestoResponse toResponse(RepuestoEntity entity) {
        if (entity == null) { return null; }

        RepuestoResponse response = new RepuestoResponse();
        response.setId(entity.getId());
        response.setNombre(entity.getNombre());
        response.setCodigoRepuesto(entity.getCodigoRepuesto());
        response.setStockActual(entity.getStockActual());
        response.setStockMinimo(entity.getStockMinimo());
        response.setPrecioVenta(entity.getPrecioVenta());

        boolean bajoStock = entity.getStockActual() <= entity.getStockMinimo();
        response.setBajoStock(bajoStock);

        return response;
    }
}