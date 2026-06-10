package com.utn.TallerAPI.features.orden;

import com.utn.TallerAPI.features.mecanico.EspecialidadRepository;
import com.utn.TallerAPI.features.mecanico.ImecanicoRepository;
import com.utn.TallerAPI.features.orden.dto.DetalleOrdenRequest;
import com.utn.TallerAPI.features.orden.dto.OrdenMecanicoRequest;
import com.utn.TallerAPI.features.orden.dto.OrdenResponse;
import com.utn.TallerAPI.features.orden.mapper.OrdenMapper;
import com.utn.TallerAPI.features.repuesto.RepuestoRepository;
import com.utn.TallerAPI.features.repuesto.RepuestoService;
import com.utn.TallerAPI.features.turno.TurnoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdenServiceImpl implements OrdenService {
    private final OrdenTrabajoRepository ordenTrabajoRepository;
    private final DetalleOrdenRepository detalleOrdenRepository;
    private final OrdenMecanicoRepository ordenMecanicoRepository;
    private final TurnoRepository turnoRepository;
    private final RepuestoRepository repuestoRepository;
    private final RepuestoService repuestoService;
    private final ImecanicoRepository mecanicoRepository;
    private final EspecialidadRepository especialidadRepository;
    private final OrdenMapper ordenMapper;

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
