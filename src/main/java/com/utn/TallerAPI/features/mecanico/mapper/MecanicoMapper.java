package com.utn.TallerAPI.features.mecanico.mapper;

import com.utn.TallerAPI.features.mecanico.dto.EspecialidadResponse;
import com.utn.TallerAPI.features.mecanico.dto.MecanicoResponse;
import com.utn.TallerAPI.features.mecanico.Especialidad;
import com.utn.TallerAPI.features.mecanico.MecanicoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MecanicoMapper {

    @Mapping(target = "usuarioId", source = "usuario.id")
    @Mapping(target = "nombre", source = "usuario.nombre")
    @Mapping(target = "apellido", source = "usuario.apellido")
    @Mapping(target = "sueldo", source = "salario")
    MecanicoResponse toResponse(MecanicoEntity mecanico);

    List<MecanicoResponse> toResponseList(List<MecanicoEntity> mecanicos);

    @Mapping(target = "descripcion", ignore = true)
    EspecialidadResponse toEspecialidadResponse(Especialidad especialidad);

    List<EspecialidadResponse> toEspecialidadResponseList(List<Especialidad> especialidades);
}