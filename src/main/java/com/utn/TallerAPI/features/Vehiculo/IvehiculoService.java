package com.utn.TallerAPI.features.Vehiculo;

import java.util.List;

public interface IvehiculoService {
    List<VehiculoDTO> obtenerTodos();
    VehiculoDTO buscarPorPatente(String patente);
}
