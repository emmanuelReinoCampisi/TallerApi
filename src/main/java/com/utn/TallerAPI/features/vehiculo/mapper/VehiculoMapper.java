package com.utn.TallerAPI.features.vehiculo.mapper;

import com.utn.TallerAPI.features.vehiculo.VehiculoEntity;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoRequest;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehiculoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "kilometraje", ignore = true)
    VehiculoEntity toEntity(VehiculoRequest request);

    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "nombreCliente", expression = "java(vehiculo.getCliente() != null ? vehiculo.getCliente().getUsuario().getNombre() + \" \" + vehiculo.getCliente().getUsuario().getApellido() : \"Vehiculo Propio del Taller\")")
    @Mapping(target = "estadoEnTaller", expression = "java(vehiculo.getEstado() != null ? vehiculo.getEstado().name() : null)")
    @Mapping(target = "esPropio", expression = "java(vehiculo.getCliente() == null)")
    VehiculoResponse toResponse(VehiculoEntity vehiculo);

    List<VehiculoResponse> toResponseList(List<VehiculoEntity> vehiculos);
}