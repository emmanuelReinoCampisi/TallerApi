package com.utn.TallerAPI.features.vehiculo;

import com.utn.TallerAPI.features.vehiculo.dto.VehiculoRequest;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface VehiculoService {

    VehiculoResponse crear(VehiculoRequest request);
    VehiculoResponse obtenerPorId(Long id);
    Page<VehiculoResponse> listarTodos(Pageable pageable);
    List<VehiculoResponse> listarPorCliente(Long clienteId);
    VehiculoResponse actualizar(String patente, VehiculoRequest request);
    VehiculoResponse actualizarEstado(Long id, EstadoVehiculo nuevoEstado);
    void eliminar(Long id);

}
