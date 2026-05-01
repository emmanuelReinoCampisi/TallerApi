package com.utn.TallerAPI.features.vehiculo;

import java.util.List;

public class VehiculoService implements IvehiculoService{


    @Override
    public List<VehiculoDTO> obtenerTodos() {
        return List.of();
    }

    @Override
    public VehiculoDTO buscarPorPatente(String patente) {
        return null;
    }
}
