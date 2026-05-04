package com.utn.TallerAPI.features.orden;

import com.utn.TallerAPI.features.orden.dto.DetalleOrdenRequest;
import com.utn.TallerAPI.features.orden.dto.OrdenMecanicoRequest;
import com.utn.TallerAPI.features.orden.dto.OrdenResponse;

import java.util.List;

public interface OrdenService {
    OrdenResponse abrir(Long turnoId);

    OrdenResponse obtenerPorId(Long id);

    List<OrdenResponse> listarPorCliente(Long clienteId);

    List<OrdenResponse> listarPorVehiculo(Long vehiculoId);

    OrdenResponse cambiarEstado(Long id, EstadoOrden nuevoEstado);

    OrdenResponse agregarDetalle(Long id, DetalleOrdenRequest request);

    OrdenResponse asignarMecanico(Long id, OrdenMecanicoRequest request);

    OrdenResponse cerrar(Long id);
}
