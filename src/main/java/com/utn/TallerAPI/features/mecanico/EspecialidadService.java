package com.utn.TallerAPI.features.Mecanico;

import com.utn.TallerAPI.features.mecanico.dto.EspecialidadRequest;
import com.utn.TallerAPI.features.mecanico.dto.EspecialidadResponse;

import java.util.List;

public interface EspecialidadService {
    EspecialidadResponse crear(EspecialidadRequest request);

    List<EspecialidadResponse> listarTodas();

    EspecialidadResponse obtenerPorId(Long id);

    void eliminar(Long id);
}
