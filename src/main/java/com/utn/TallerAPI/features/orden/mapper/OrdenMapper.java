package com.utn.TallerAPI.features.orden.mapper;

import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.orden.OrdenMecanico;
import com.utn.TallerAPI.features.orden.OrdenTrabajo;
import com.utn.TallerAPI.features.orden.dto.OrdenMecanicoResponse;
import com.utn.TallerAPI.features.orden.dto.OrdenResponse;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {DetalleOrdenMapper.class})
public abstract class OrdenMapper {

    @Autowired
    protected DetalleOrdenMapper detalleOrdenMapper;

    public OrdenResponse toResponse(OrdenTrabajo orden) {
        if (orden == null) { return null; }

        OrdenResponse response = new OrdenResponse();
        response.setId(orden.getId());

        if (orden.getEstado() != null) {
            response.setEstado(orden.getEstado().name());
        }

        // Navegación segura por las relaciones del Turno
        if (orden.getTurno() != null) {
            response.setTurnoId(orden.getTurno().getId());

            if (orden.getTurno().getVehiculoId() != null) {
                response.setVehiculoPatente(orden.getTurno().getPatenteVehiculo());
            }

            response.setClienteNombre(this.nombreCliente(orden.getTurno().getCliente()));
        }

        // Mapeo seguro de la lista de repuestos/detalles
        if (orden.getDetalles() != null) {
            response.setDetalles(detalleOrdenMapper.toResponseList(orden.getDetalles()));
        }

        // Mapeo seguro de la lista de mecánicos asignados
        if (orden.getMecanicos() != null) {
            response.setMecanicos(this.toMecanicoResponseList(orden.getMecanicos()));
        }

        return response;
    }

    public OrdenMecanicoResponse toMecanicoResponse(OrdenMecanico ordenMecanico) {
        if (ordenMecanico == null) { return null; }

        OrdenMecanicoResponse response = new OrdenMecanicoResponse();

        if (ordenMecanico.getMecanico() != null) {
            if (ordenMecanico.getMecanico().getEspecialidad() != null) {
                response.setEspecialidadNombre(ordenMecanico.getMecanico().getEspecialidad().getNombre());
            }

            if (ordenMecanico.getMecanico().getUsuario() != null) {
                String nombreCompleto = (ordenMecanico.getMecanico().getUsuario().getNombre() + " " +
                        ordenMecanico.getMecanico().getUsuario().getApellido()).trim();
                response.setMecanicoNombre(nombreCompleto);
            }
        }

        return response;
    }

    public List<OrdenMecanicoResponse> toMecanicoResponseList(List<OrdenMecanico> mecanicos) {
        if (mecanicos == null) { return null; }
        List<OrdenMecanicoResponse> lista = new ArrayList<>();
        for (OrdenMecanico om : mecanicos) {
            lista.add(this.toMecanicoResponse(om));
        }
        return lista;
    }

    private String nombreCliente(ClienteEntity cliente) {
        if (cliente == null || cliente.getUsuario() == null) {
            return null;
        }
        return (cliente.getUsuario().getNombre() + " " + cliente.getUsuario().getApellido()).trim();
    }
}