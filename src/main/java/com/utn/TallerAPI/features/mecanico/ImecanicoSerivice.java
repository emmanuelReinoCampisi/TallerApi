package com.utn.TallerAPI.features.mecanico;

import com.utn.TallerAPI.features.mecanico.dto.EspecialidadRequest;
import com.utn.TallerAPI.features.mecanico.dto.EspecialidadResponse;
import com.utn.TallerAPI.features.mecanico.dto.MecanicoRequest;
import com.utn.TallerAPI.features.mecanico.dto.MecanicoResponse;

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
