package com.utn.TallerAPI.features.mecanico.mapper;

import com.utn.TallerAPI.features.mecanico.dto.EspecialidadRequest;
import com.utn.TallerAPI.features.mecanico.dto.EspecialidadResponse;
import com.utn.TallerAPI.features.mecanico.Especialidad;
import org.mapstruct.Mapper;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class EspecialidadMapper {

    public EspecialidadResponse toResponse(Especialidad especialidad) {
        if (especialidad == null) { return null; }

        EspecialidadResponse response = new EspecialidadResponse();
        response.setId(especialidad.getId());
        response.setNombre(especialidad.getNombreEspecialidad());
        return response;
    }

    public Especialidad toEntity(EspecialidadRequest request) {
        if (request == null) { return null; }

        Especialidad especialidad = new Especialidad();
        especialidad.setNombreEspecialidad(request.getNombre());
        return especialidad;
    }

    public List<EspecialidadResponse> toResponseList(List<Especialidad> especialidades) {
        if (especialidades == null) { return null; }

        List<EspecialidadResponse> list = new ArrayList<>();
        for (Especialidad esp : especialidades) {
            list.add(toResponse(esp));
        }
        return list;
    }
}