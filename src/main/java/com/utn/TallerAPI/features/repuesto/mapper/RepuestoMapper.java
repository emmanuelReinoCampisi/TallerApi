package com.utn.TallerAPI.features.repuesto.mapper;

import com.utn.TallerAPI.features.repuesto.RepuestoEntity;
import com.utn.TallerAPI.features.repuesto.dto.RepuestoRequest;
import com.utn.TallerAPI.features.repuesto.dto.RepuestoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface RepuestoMapper {

    @Mapping(target = "idRepuesto", ignore = true)
    RepuestoEntity toEntity (RepuestoRequest repuestoRequest);

    @Mapping(target = "bajoStock", expression = "java(repuestoEntity.getStockActual() <= repuestoEntity.getStockMinimo())")
    RepuestoResponse toResponse(RepuestoEntity repuestoEntity);

}
