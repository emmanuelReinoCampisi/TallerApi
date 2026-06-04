package com.utn.TallerAPI.features.orden.mapper;

import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.orden.OrdenMecanico;
import com.utn.TallerAPI.features.orden.OrdenTrabajo;
import com.utn.TallerAPI.features.orden.dto.OrdenMecanicoResponse;
import com.utn.TallerAPI.features.orden.dto.OrdenResponse;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrdenMapper {

    @Autowired
    protected DetalleOrdenMapper detalleOrdenMapper;

    public OrdenResponse toResponse(OrdenTrabajo orden) {
        if (orden == null) { return null; }

        OrdenResponse response = new OrdenResponse();
        response.setFechaApertura(orden.getFechaApertura());
        response.setFechaCierre(orden.getFechaCierre());
        response.setDiagnostico(orden.getDiagnostico());
        response.setSubtotal(BigDecimal.valueOf(orden.getSubtotal()));
        response.setDescuento(BigDecimal.valueOf(orden.getDescuento()));
        response.setTotal(BigDecimal.valueOf(orden.getTotal()));
        response.setPagada(orden.isPagada());

        if (orden.getTurno() != null) {
            response.setId(orden.getTurno().getId());


            if (orden.getTurno().getVehiculo() != null) {
                response.setVehiculoPatente(orden.getTurno().getVehiculo().getPatente());
            }

            response.setClienteNombre(nombreCliente(orden.getTurno().getCliente()));
        }


        if (orden.getEstado() != null) {
            response.setEstado(orden.getEstado().name());
        }

        if (orden.getDetalles() != null) {
            response.setDetalles(detalleOrdenMapper.toResponseList(orden.getDetalles()));
        }

        return response;
    }

    public OrdenMecanicoResponse toMecanicoResponse(OrdenMecanico ordenMecanico) {
        if (ordenMecanico == null) { return null; }

        OrdenMecanicoResponse response = new OrdenMecanicoResponse();
        response.setIdOrdenMecanico(ordenMecanico.getIdOrdenMecanico());
        response.setObservaciones(ordenMecanico.getObservaciones());

        if (ordenMecanico.getMecanico() != null) {
            if (ordenMecanico.getMecanico().getUsuario() != null) {
                String nombreCompleto = ordenMecanico.getMecanico().getUsuario().getNombre() + " " +
                        ordenMecanico.getMecanico().getUsuario().getApellido();
                response.setMecanicoNombre(nombreCompleto.trim());
            }

            if (ordenMecanico.getMecanico().getEspecialidad() != null) {
                response.setEspecialidadNombre(ordenMecanico.getMecanico().getEspecialidad().getNombre());
            }
        }

        return response;
    }

    public List<OrdenMecanicoResponse> toMecanicoResponseList(List<OrdenMecanico> mecanicos) {
        if (mecanicos == null) { return null; }

        List<OrdenMecanicoResponse> list = new ArrayList<>();
        for (OrdenMecanico om : mecanicos) {
            list.add(toMecanicoResponse(om));
        }
        return list;
    }

    public String nombreCliente(ClienteEntity cliente) {
        if (cliente == null || cliente.getUsuario() == null) {
            return null;
        }
        return (cliente.getUsuario().getNombre() + " " + cliente.getUsuario().getApellido()).trim();
    }
}