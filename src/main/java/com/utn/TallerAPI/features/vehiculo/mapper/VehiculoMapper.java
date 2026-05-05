package com.utn.TallerAPI.features.vehiculo.mapper;

import com.utn.TallerAPI.features.vehiculo.VehiculoEntity;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoRequest;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehiculoMapper {

    @Mapping(target = "clienteId",source = "cliente.id")
    @Mapping(target = "nombreCliente", expression = "java(vehiculo.getCliente() != null ? vehiculo.getCliente().getUsuario().getNombre() + ' ' + vehiculo.getCliente().getUsuario().getApellido() : \"Vehículo propio\")")
    @Mapping(target = "estadoEnTaller", expression = "java(vehiculo.getEstadoEnTaller().name())")
    VehiculoResponse toResponse(VehiculoEntity vehiculo);

    List<VehiculoResponse> toResponseList(List<VehiculoEntity> vehiculos);
    VehiculoEntity toEntity(VehiculoRequest request);
}
