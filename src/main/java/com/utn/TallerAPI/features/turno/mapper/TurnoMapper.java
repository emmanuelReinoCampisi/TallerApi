package com.utn.TallerAPI.features.turno.mapper;

import com.utn.TallerAPI.features.turno.TurnoEntity;
import com.utn.TallerAPI.features.turno.dto.TurnoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TurnoMapper {

    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "nombreCliente", expression = "java(turno.getCliente() != null ? turno.getCliente().getUsuario().getNombre() + \" \" + turno.getCliente().getUsuario().getApellido() : null)")
    @Mapping(target = "vehiculoId", source = "vehiculo.id")
    @Mapping(target = "patenteVehiculo", source = "vehiculo.patente")
    @Mapping(target = "creadoPor", expression = "java(turno.getCreadoPor() != null ? turno.getCreadoPor().getNombre() + \" \" + turno.getCreadoPor().getApellido() : null)")
    @Mapping(target = "estado", expression = "java(turno.getEstado() != null ? turno.getEstado().name() : null)")
    public abstract TurnoResponse toResponse(TurnoEntity turno);

    public abstract List<TurnoResponse> toResponseList(List<TurnoEntity> turnos);
}