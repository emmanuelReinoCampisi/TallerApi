package com.utn.TallerAPI.features.orden;

import com.utn.TallerAPI.features.cliente.TipoCliente;
import com.utn.TallerAPI.features.mecanico.EspecialidadRepository;
import com.utn.TallerAPI.features.mecanico.ImecanicoRepository;
import com.utn.TallerAPI.features.orden.dto.DetalleOrdenRequest;
import com.utn.TallerAPI.features.orden.dto.OrdenMecanicoRequest;
import com.utn.TallerAPI.features.orden.dto.OrdenResponse;
import com.utn.TallerAPI.features.orden.mapper.OrdenMapper;
import com.utn.TallerAPI.features.repuesto.RepuestoRepository;
import com.utn.TallerAPI.features.repuesto.RepuestoService;
import com.utn.TallerAPI.features.turno.TurnoRepository;

import java.util.List;
import java.util.Map;

public class OrdenServiceImpl implements OrdenService {
    private  OrdenTrabajoRepository ordenTrabajoRepository;
    private  DetalleOrdenRepository detalleOrdenRepository;
    private  OrdenMecanicoRepository ordenMecanicoRepository;
    private  TurnoRepository turnoRepository;
    private  RepuestoRepository repuestoRepository;
    private  RepuestoService repuestoService;
    private  ImecanicoRepository mecanicoRepository;
    private  EspecialidadRepository especialidadRepository;
    //private final HistorialVehiculoRepository historialVehiculoRepository;
    private  OrdenMapper ordenMapper;

    @Override
    public OrdenResponse abrir(Long turnoId) {
        return null;
    }

    @Override
    public OrdenResponse obtenerPorId(Long id) {
        return null;
    }

    @Override
    public List<OrdenResponse> listarPorCliente(Long clienteId) {
        return List.of();
    }

    @Override
    public List<OrdenResponse> listarPorVehiculo(Long vehiculoId) {
        return List.of();
    }

    @Override
    public OrdenResponse cambiarEstado(Long id, EstadoOrden nuevoEstado) {
        return null;
    }

    @Override
    public OrdenResponse agregarDetalle(Long id, DetalleOrdenRequest request) {
        return null;
    }

    @Override
    public OrdenResponse asignarMecanico(Long id, OrdenMecanicoRequest request) {
        return null;
    }

    @Override
    public OrdenResponse cerrar(Long id) {
        return null;
    }
}
