package com.utn.TallerAPI.features.Mecanico;

import com.utn.TallerAPI.features.Mecanico.DTO.EspecialidadRequest;
import com.utn.TallerAPI.features.Mecanico.DTO.EspecialidadResponse;
import com.utn.TallerAPI.features.Mecanico.DTO.MecanicoRequest;
import com.utn.TallerAPI.features.Mecanico.DTO.MecanicoResponse;

import java.util.List;

public interface ImecanicoSerivice {

    MecanicoResponse crear (MecanicoRequest request);
    MecanicoResponse obtenerPorId(Long id);
    List<MecanicoResponse> listarActivos();
    MecanicoResponse actualizar(Long id,MecanicoRequest request);
    MecanicoResponse asignarEspecialidades(Long id,List<Long>IdsEspecialidades);
    void desactivarMecanico(Long id);
    List<MecanicoResponse> listarPorEspecialidad(Long IdEspecialidad);
    EspecialidadResponse crearEspecialidad(EspecialidadRequest request);
    List<EspecialidadResponse> listarEspecialidades();
    EspecialidadResponse obtenerEspecialidadPorId(Long id);
    void eliminarEspecialidad(Long id);

}
