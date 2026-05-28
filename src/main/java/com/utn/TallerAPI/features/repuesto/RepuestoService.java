package com.utn.TallerAPI.features.repuesto;

import com.utn.TallerAPI.features.repuesto.dto.RepuestoRequest;
import com.utn.TallerAPI.features.repuesto.dto.RepuestoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RepuestoService {
    RepuestoResponse registrar(RepuestoRequest request);
    RepuestoResponse obtenerPorId(Long id);
    RepuestoResponse actualizarStock(Long id, Integer nuevaCantidad);
    List<RepuestoResponse> listarTodos();
    List<RepuestoResponse> listarBajoStock();
}
