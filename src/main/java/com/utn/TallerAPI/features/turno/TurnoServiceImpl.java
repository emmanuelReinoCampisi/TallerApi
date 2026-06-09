package com.utn.TallerAPI.features.turno;

import com.utn.TallerAPI.Exception.BusinessException;
import com.utn.TallerAPI.Exception.ResourceNotFoundException;
import com.utn.TallerAPI.features.cliente.ClienteRepository;
import com.utn.TallerAPI.features.turno.dto.TurnoRequest;
import com.utn.TallerAPI.features.turno.dto.TurnoResponse;
import com.utn.TallerAPI.features.turno.mapper.TurnoMapper;
import com.utn.TallerAPI.features.usuario.UsuarioRepository;
import com.utn.TallerAPI.features.vehiculo.VehiculoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurnoServiceImpl implements TurnoService {

    private final TurnoRepository turnoRepository;
    private final ClienteRepository clienteRepository;
    private final VehiculoRepository vehiculoRepository;
    private final UsuarioRepository usuarioRepository;
    private final TurnoMapper turnoMapper;

    @Override
    @Transactional
    public TurnoResponse crear(TurnoRequest request, String usernameCreador) {
        var cliente = request.getClienteId() != null
                ? clienteRepository.findById(request.getClienteId())
                        .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"))
                : null;

        var vehiculo = vehiculoRepository.findById(request.getVehiculoId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado"));

        var creadoPor = usuarioRepository.findByUserName(usernameCreador)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        TurnoEntity turno = TurnoEntity.builder()
                .cliente(cliente)
                .vehiculo(vehiculo)
                .creadoPor(creadoPor)
                .fechaYhoraIngreso(request.getFechaYhoraIngreso())
                .fechaYhoraSalida(request.getFechaEntrega() != null ? request.getFechaEntrega().atStartOfDay() : null)
                .estado(EstadoTurno.PENDIENTE)
                .descripcion(request.getDescripcion())
                .build();

        return turnoMapper.toResponse(turnoRepository.save(turno));
    }

    @Override
    public TurnoResponse obtenerPorId(Long id) {
        return turnoMapper.toResponse(findById(id));
    }

    @Override
    public Page<TurnoResponse> listarTodos(Pageable pageable) {
        return turnoRepository.findAll(pageable).map(turnoMapper::toResponse);
    }

    @Override
    public List<TurnoResponse> listarPorCliente(Long clienteId) {
        return turnoMapper.toResponseList(turnoRepository.findByClienteId(clienteId));
    }

    @Override
    public List<TurnoResponse> listarPorFecha(LocalDate fecha) {
        return turnoMapper.toResponseList(
                turnoRepository.findByFechaYhoraIngresoBetween(
                        fecha.atStartOfDay(), fecha.atTime(23, 59, 59)));
    }

    @Override
    @Transactional
    public TurnoResponse cambiarEstado(Long id, EstadoTurno nuevoEstado) {
        TurnoEntity turno = findById(id);
        validarTransicion(turno.getEstado(), nuevoEstado);
        turno.setEstado(nuevoEstado);
        return turnoMapper.toResponse(turnoRepository.save(turno));
    }

    @Override
    @Transactional
    public void cancelar(Long id) {
        TurnoEntity turno = findById(id);
        if (turno.getEstado() != EstadoTurno.PENDIENTE &&
                turno.getEstado() != EstadoTurno.CONFIRMADO) {
            throw new BusinessException(
                    "No se puede cancelar un turno en estado " + turno.getEstado());
        }
        turno.setEstado(EstadoTurno.CANCELADO);
        turnoRepository.save(turno);
    }

    private void validarTransicion(EstadoTurno actual, EstadoTurno nuevo) {
        boolean valida = switch (actual) {
            case PENDIENTE -> nuevo == EstadoTurno.CONFIRMADO || nuevo == EstadoTurno.CANCELADO;
            case CONFIRMADO -> nuevo == EstadoTurno.EN_PROCESO || nuevo == EstadoTurno.CANCELADO;
            case EN_PROCESO -> nuevo == EstadoTurno.FINALIZADO;
            default -> false;
        };
        if (!valida) {
            throw new BusinessException("Transición de estado inválida: " + actual + " → " + nuevo);
        }
    }

    private TurnoEntity findById(Long id) {
        return turnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Turno no encontrado con id: " + id));
    }
}