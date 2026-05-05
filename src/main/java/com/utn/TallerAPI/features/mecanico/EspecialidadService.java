package com.utn.TallerAPI.features.Mecanico;

import com.utn.TallerAPI.features.Mecanico.DTO.EspecialidadRequest;
import com.utn.TallerAPI.features.Mecanico.DTO.EspecialidadResponse;

import java.util.List;

public interface EspecialidadService {
    EspecialidadResponse crear(EspecialidadRequest request);

    List<EspecialidadResponse> listarTodas();

    EspecialidadResponse obtenerPorId(Long id);

    void eliminar(Long id);
}
