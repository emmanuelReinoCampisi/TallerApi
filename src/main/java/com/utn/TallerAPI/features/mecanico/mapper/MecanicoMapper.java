package com.utn.TallerAPI.features.mecanico.mapper;

import com.utn.TallerAPI.features.mecanico.dto.EspecialidadResponse;
import com.utn.TallerAPI.features.mecanico.dto.MecanicoResponse;
import com.utn.TallerAPI.features.mecanico.Especialidad;
import com.utn.TallerAPI.features.mecanico.MecanicoEntity;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class MecanicoMapper {

    public MecanicoResponse toResponse(MecanicoEntity mecanico) {
        if (mecanico == null) { return null; }

        MecanicoResponse response = new MecanicoResponse();

        response.setId(mecanico.getId());
        response.setLegajo(mecanico.getLegajo());
        response.setSueldo(mecanico.getSalario());
        response.setFechaIngreso(mecanico.getFechaIngreso());
        response.setActivo(mecanico.isActivo());

        if (mecanico.getUsuario() != null) {
            response.setNombre(mecanico.getUsuario().getNombre());
            response.setApellido(mecanico.getUsuario().getApellido());
        }

        return response;
    }

    public List<MecanicoResponse> toResponseList(List<MecanicoEntity> mecanicos) {
        if (mecanicos == null) { return null; }

        List<MecanicoResponse> list = new ArrayList<>();
        for (MecanicoEntity m : mecanicos) {
            list.add(toResponse(m));
        }
        return list;
    }

    public EspecialidadResponse toEspecialidadResponse(Especialidad especialidad) {
        if (especialidad == null) { return null; }

        EspecialidadResponse response = new EspecialidadResponse();
        response.setId(especialidad.getId());
        response.setNombre(especialidad.getNombreEspecialidad());
        return response;
    }

    public List<EspecialidadResponse> toEspecialidadResponseList(List<Especialidad> especialidades) {
        if (especialidades == null) { return null; }

        List<EspecialidadResponse> list = new ArrayList<>();
        for (Especialidad e : especialidades) {
            list.add(toEspecialidadResponse(e));
        }
        return list;
    }
}