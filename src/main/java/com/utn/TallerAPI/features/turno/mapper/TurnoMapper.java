package com.utn.TallerAPI.features.turno.mapper;

import com.utn.TallerAPI.features.turno.TurnoEntity;
import com.utn.TallerAPI.features.turno.dto.TurnoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurnoMapper {

    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "nombreCliente", expression = "java(turno.getCliente() != null ? turno.getCliente().getUsuario().getNombre() + ' ' + turno.getCliente().getUsuario().getApellido() : null)")
    @Mapping(target = "vehiculoId", source = "vehiculo.id")
    @Mapping(target = "patenteVehiculo", source = "vehiculo.patente")
    @Mapping(target = "estado", expression = "java(turno.getEstado().name())")
    @Mapping(target = "creadoPor", source = "creadoPor.username")
    TurnoResponse toResponse(TurnoEntity turno);
    List<TurnoResponse> toResponseList(List<TurnoEntity> turnos);

}
