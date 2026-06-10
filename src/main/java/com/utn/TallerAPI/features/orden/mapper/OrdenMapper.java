package com.utn.TallerAPI.features.orden.mapper;

import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.orden.OrdenMecanico;
import com.utn.TallerAPI.features.orden.OrdenTrabajo;
import com.utn.TallerAPI.features.orden.dto.OrdenMecanicoResponse;
import com.utn.TallerAPI.features.orden.dto.OrdenResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring", uses = {DetalleOrdenMapper.class})
public abstract class OrdenMapper {


    @Mapping(target = "id", source = "turno.id")
    @Mapping(target = "vehiculoPatente", source = "turno.vehiculo.patente")
    @Mapping(target = "clienteNombre", expression = "java(nombreCliente(orden.getTurno().getCliente()))")
    @Mapping(target = "estado", expression = "java(orden.getEstado().name())")
    @Mapping(target = "detalles", source = "detalles")
    @Mapping(target = "mecanicos", ignore = true)
    public abstract OrdenResponse toResponse(OrdenTrabajo orden);


    @Mapping(target = "mecanicoNombre", expression = "java(ordenMecanico.getMecanico().getUsuario().getNombre() + \" \" + ordenMecanico.getMecanico().getUsuario().getApellido())")
    @Mapping(target = "especialidadNombre", source = "especialidad.nombreEspecialidad")
    public abstract OrdenMecanicoResponse toMecanicoResponse(OrdenMecanico ordenMecanico);

    public abstract List<OrdenMecanicoResponse> toMecanicoResponseList(List<OrdenMecanico> mecanicos);

    protected String nombreCliente(ClienteEntity cliente) {
        if (cliente == null || cliente.getUsuario() == null) {
            return null;
        }
        return (cliente.getUsuario().getNombre() + " " + cliente.getUsuario().getApellido()).trim();
    }
}