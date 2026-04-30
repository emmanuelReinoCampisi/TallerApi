package com.utn.TallerAPI.features.Mecanico.Mapper;
import com.utn.TallerAPI.features.Mecanico.DTO.EspecialidadResponse;
import com.utn.TallerAPI.features.Mecanico.DTO.MecanicoResponse;
import com.utn.TallerAPI.features.Mecanico.Especialidad;
import com.utn.TallerAPI.features.Mecanico.MecanicoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper()
public interface MecanicoMapper {
    @Mapping(target = "usuarioId", source = "usuario.id")
    @Mapping(target = "nombre", source = "usuario.nombre")
    @Mapping(target = "apellido", source = "usuario.apellido")
    MecanicoResponse toResponse(MecanicoEntity mecanico);
    List<MecanicoResponse> toResponseList(List<MecanicoEntity> mecanicos);
    EspecialidadResponse toEspecialidadResponse(Especialidad especialidad);
    List<EspecialidadResponse> toEspecialidadResponseList(Optional<List<Especialidad>> especialidades);
}
