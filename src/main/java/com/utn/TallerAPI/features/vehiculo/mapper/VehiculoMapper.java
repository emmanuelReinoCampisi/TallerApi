package com.utn.TallerAPI.features.vehiculo.mapper;

import com.utn.TallerAPI.features.vehiculo.VehiculoEntity;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoRequest;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoResponse;
import org.mapstruct.Mapper;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class VehiculoMapper {

    public VehiculoEntity toEntity(VehiculoRequest request) {
        if (request == null) { return null; }

        VehiculoEntity vehiculo = new VehiculoEntity();
        vehiculo.setPatente(request.getPatente());
        vehiculo.setMarca(request.getMarca());
        vehiculo.setModelo(request.getModelo());
        vehiculo.setAnio(request.getAnio());
        vehiculo.setColor(request.getColor());
        vehiculo.setKilometraje(request.getKilometraje());
        // Nota: La relación con ClienteEntity se asigna normalmente en el Service usando el clienteId
        return vehiculo;
    }

    public VehiculoResponse toResponse(VehiculoEntity vehiculo) {
        if (vehiculo == null) { return null; }

        VehiculoResponse response = new VehiculoResponse();
        // Sincronizado con 'idVehiculo' de tu modelo UML
        response.setId(vehiculo.getId());
        response.setPatente(vehiculo.getPatente());
        response.setMarca(vehiculo.getMarca());
        response.setModelo(vehiculo.getModelo());
        response.setAnio(vehiculo.getAnio());
        response.setColor(vehiculo.getColor());
        response.setKilometraje(vehiculo.getKilometraje());
        response.setEstadoEnTaller(vehiculo.getEstado());


        if (vehiculo.getCliente() != null) {
            response.setClienteId(vehiculo.getCliente().getId());
        }

        return response;
    }

    public List<VehiculoResponse> toResponseList(List<VehiculoEntity> vehiculos) {
        if (vehiculos == null) { return null; }

        List<VehiculoResponse> lista = new ArrayList<>();
        for (VehiculoEntity v : vehiculos) {
            lista.add(toResponse(v));
        }
        return lista;
    }
}