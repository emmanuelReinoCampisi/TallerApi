package com.utn.TallerAPI.features.vehiculo;

import java.util.List;

public interface IvehiculoService {
    List<VehiculoDTO> obtenerTodos();
    VehiculoDTO buscarPorPatente(String patente);
}
