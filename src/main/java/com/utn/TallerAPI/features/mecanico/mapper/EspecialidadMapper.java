package com.utn.TallerAPI.features.Mecanico.Mapper;

import com.utn.TallerAPI.features.Mecanico.DTO.EspecialidadRequest;
import com.utn.TallerAPI.features.Mecanico.DTO.EspecialidadResponse;
import com.utn.TallerAPI.features.Mecanico.Especialidad;
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
