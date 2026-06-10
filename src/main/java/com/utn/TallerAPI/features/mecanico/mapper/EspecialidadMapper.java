package com.utn.TallerAPI.features.mecanico.mapper;

import com.utn.TallerAPI.features.mecanico.dto.EspecialidadRequest;
import com.utn.TallerAPI.features.mecanico.dto.EspecialidadResponse;
import com.utn.TallerAPI.features.mecanico.Especialidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface EspecialidadMapper {

    EspecialidadResponse toResponse(Especialidad especialidad);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mecanicos", ignore = true)
    Especialidad toEntity(EspecialidadRequest request);

    List<EspecialidadResponse> toResponseList(List<Especialidad> especialidades);
}
