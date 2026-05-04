package com.utn.TallerAPI.features.orden.mapper;

import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.orden.OrdenMecanico;
import com.utn.TallerAPI.features.orden.OrdenTrabajo;
import com.utn.TallerAPI.features.orden.dto.OrdenMecanicoResponse;
import com.utn.TallerAPI.features.orden.dto.OrdenResponse;
import com.utn.TallerAPI.features.usuario.mapper.UsuarioMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring",uses = {DetalleOrdenMapper.class})
public interface OrdenMapper {
    @Mapping(target = "turnoId", source = "turno.id")
    @Mapping(target = "vehiculoPatente", source = "turno.vehiculo.patente")
    @Mapping(target = "clienteNombre", expression = "java(nombreCliente(orden.getTurno().getCliente()))")
    @Mapping(target = "estado", expression = "java(orden.getEstado().name())")
    @Mapping(target = "detalles", source = "detalles")
    @Mapping(target = "mecanicos", ignore = true)
    OrdenResponse toResponse(OrdenTrabajo orden);

    @Mapping(target = "mecanicoNombre", expression = "java(ordenMecanico.getMecanico().getNombre() + \" \" + ordenMecanico.getMecanico().getApellido())")
    @Mapping(target = "especialidadNombre", source = "especialidad.nombre")
    OrdenMecanicoResponse toMecanicoResponse(OrdenMecanico ordenMecanico);

    List<OrdenMecanicoResponse> toMecanicoResponseList(List<OrdenMecanico> mecanicos);

    default String nombreCliente(ClienteEntity cliente) {
        if (cliente == null) {
            return null;
        }
        return (cliente.getNombre() + " " + cliente.getApellido()).trim();
    }
}
