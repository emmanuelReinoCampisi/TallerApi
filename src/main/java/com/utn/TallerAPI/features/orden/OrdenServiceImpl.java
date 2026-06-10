package com.utn.TallerAPI.features.orden;

import com.utn.TallerAPI.Exception.BusinessException;
import com.utn.TallerAPI.Exception.ResourceNotFoundException;
import com.utn.TallerAPI.features.mecanico.Especialidad;
import com.utn.TallerAPI.features.mecanico.EspecialidadRepository;
import com.utn.TallerAPI.features.mecanico.ImecanicoRepository;
import com.utn.TallerAPI.features.mecanico.MecanicoEntity;
import com.utn.TallerAPI.features.orden.dto.DetalleOrdenRequest;
import com.utn.TallerAPI.features.orden.dto.OrdenMecanicoRequest;
import com.utn.TallerAPI.features.orden.dto.OrdenResponse;
import com.utn.TallerAPI.features.orden.mapper.OrdenMapper;
import com.utn.TallerAPI.features.repuesto.RepuestoEntity;
import com.utn.TallerAPI.features.repuesto.RepuestoRepository;
import com.utn.TallerAPI.features.repuesto.RepuestoService;
import com.utn.TallerAPI.features.turno.TurnoEntity;
import com.utn.TallerAPI.features.turno.TurnoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    @Transactional
    public OrdenResponse abrir(Long turnoId) {
        TurnoEntity turno = turnoRepository.findById(turnoId)
                .orElseThrow(() -> new ResourceNotFoundException("Turno no encontrado con ID: " + turnoId));

        if (ordenTrabajoRepository.findByTurnoId(turnoId).isPresent()) {
            throw new BusinessException("El turno ya tiene una orden de trabajo asociada");
        }

        OrdenTrabajo orden = new OrdenTrabajo();
        orden.setTurno(turno);
        orden.setFechaApertura(LocalDate.now());
        orden.setEstado(EstadoOrden.ABIERTA);
        orden.setSubtotal(0.0);
        orden.setDescuento(0.0);
        orden.setTotal(0.0);
        orden.setPagada(false);

        OrdenTrabajo saved = ordenTrabajoRepository.save(orden);
        return ordenMapper.toResponse(saved);
    }

    @Override
    public OrdenResponse obtenerPorId(Long id) {
        OrdenTrabajo orden = ordenTrabajoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orden no encontrada con ID: " + id));
        return ordenMapper.toResponse(orden);
    }

    @Override
    public List<OrdenResponse> listarPorCliente(Long clienteId) {
        return ordenTrabajoRepository.findByTurno_Cliente_Id(clienteId).stream()
                .map(ordenMapper::toResponse)
                .toList();
    }

    @Override
    public List<OrdenResponse> listarPorVehiculo(Long vehiculoId) {
        return ordenTrabajoRepository.findByTurno_Vehiculo_Id(vehiculoId).stream()
                .map(ordenMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public OrdenResponse cambiarEstado(Long id, EstadoOrden nuevoEstado) {
        OrdenTrabajo orden = ordenTrabajoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orden no encontrada con ID: " + id));

        if (!esTransicionValida(orden.getEstado(), nuevoEstado)) {
            throw new BusinessException("Transición de estado inválida: " + orden.getEstado() + " → " + nuevoEstado);
        }

        orden.setEstado(nuevoEstado);
        OrdenTrabajo saved = ordenTrabajoRepository.save(orden);
        return ordenMapper.toResponse(saved);
    }

    private boolean esTransicionValida(EstadoOrden actual, EstadoOrden nuevo) {
        return switch (actual) {
            case ABIERTA -> nuevo == EstadoOrden.EN_PROCESO
                    || nuevo == EstadoOrden.ESPERANDO_REPUESTO
                    || nuevo == EstadoOrden.CANCELADA;
            case EN_PROCESO -> nuevo == EstadoOrden.ESPERANDO_REPUESTO
                    || nuevo == EstadoOrden.LISTA
                    || nuevo == EstadoOrden.CANCELADA;
            case ESPERANDO_REPUESTO -> nuevo == EstadoOrden.EN_PROCESO
                    || nuevo == EstadoOrden.CANCELADA;
            case LISTA -> nuevo == EstadoOrden.CERRADA
                    || nuevo == EstadoOrden.CANCELADA;
            case CERRADA, CANCELADA -> false;
        };
    }

    @Override
    @Transactional
    public OrdenResponse agregarDetalle(Long id, DetalleOrdenRequest request) {
        OrdenTrabajo orden = ordenTrabajoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orden no encontrada con ID: " + id));

        RepuestoEntity repuesto = repuestoRepository.findById(request.repuestoId())
                .orElseThrow(() -> new ResourceNotFoundException("Repuesto no encontrado con ID: " + request.repuestoId()));

        DetalleOrden detalle = new DetalleOrden();
        detalle.setOrden(orden);
        detalle.setRepuesto(repuesto);
        detalle.setDescripcionTrabajo(request.descripcionTrabajo());
        detalle.setCantidad(request.cantidad() != null ? request.cantidad() : 1);
        detalle.setPrecioUnitario(request.precioUnitario());

        detalleOrdenRepository.save(detalle);

        recalcularTotales(orden);
        OrdenTrabajo saved = ordenTrabajoRepository.save(orden);

        return ordenMapper.toResponse(saved);
    }

    private void recalcularTotales(OrdenTrabajo orden) {
        double subtotal = orden.getDetalles().stream()
                .mapToDouble(d -> d.getCantidad() * d.getPrecioUnitario().doubleValue())
                .sum();
        orden.setSubtotal(subtotal);
        orden.setTotal(subtotal - (orden.getDescuento() != null ? orden.getDescuento() : 0.0));
    }

    @Override
    @Transactional
    public OrdenResponse asignarMecanico(Long id, OrdenMecanicoRequest request) {
        OrdenTrabajo orden = ordenTrabajoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orden no encontrada con ID: " + id));

        MecanicoEntity mecanico = mecanicoRepository.findById(request.mecanicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Mecánico no encontrado con ID: " + request.mecanicoId()));

        Especialidad especialidad = especialidadRepository.findById(request.especialidadId())
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada con ID: " + request.especialidadId()));

        OrdenMecanico om = new OrdenMecanico();
        om.setOrden(orden);
        om.setMecanico(mecanico);
        om.setEspecialidad(especialidad);
        om.setObservaciones(request.observaciones());

        ordenMecanicoRepository.save(om);

        return ordenMapper.toResponse(orden);
    }

    @Override
    @Transactional
    public OrdenResponse cerrar(Long id) {
        OrdenTrabajo orden = ordenTrabajoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orden no encontrada con ID: " + id));

        if (orden.getDetalles().isEmpty()) {
            throw new BusinessException("No se puede cerrar una orden sin detalles");
        }

        orden.setEstado(EstadoOrden.CERRADA);
        orden.setFechaCierre(LocalDate.now());

        OrdenTrabajo saved = ordenTrabajoRepository.save(orden);
        return ordenMapper.toResponse(saved);
    }
}
