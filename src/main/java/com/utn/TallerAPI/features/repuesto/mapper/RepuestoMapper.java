package com.utn.TallerAPI.features.repuesto.mapper;

import com.utn.TallerAPI.features.repuesto.RepuestoEntity;
import com.utn.TallerAPI.features.repuesto.dto.RepuestoRequest;
import com.utn.TallerAPI.features.repuesto.dto.RepuestoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepuestoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nombre", source = "nombreRepuesto")
    RepuestoEntity toEntity(RepuestoRequest request);

    @Mapping(target = "bajoStock", expression = "java(entity.getStockActual() <= entity.getStockMinimo())")
    RepuestoResponse toResponse(RepuestoEntity entity);

    List<RepuestoResponse> toResponseList(List<RepuestoEntity> entities);
}