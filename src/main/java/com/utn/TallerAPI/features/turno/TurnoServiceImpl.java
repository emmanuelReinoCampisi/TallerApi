package com.utn.TallerAPI.features.turno;

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
public class TurnoServiceImpl implements TurnoService{

    private final TurnoRepository turnoRepository;
    //private final ClienteRepository clienteRepository;
    private final VehiculoRepository vehiculoRepository;
    private final UsuarioRepository usuarioRepository;
    //private final ConfigTallerRepository configTallerRepository;
    private final TurnoMapper turnoMapper;


/*
    @Override
    @Transactional
    public TurnoResponse crear(TurnoRequest request, String usernameCreador) {
        ConfigTaller config = configTallerRepository.findFirst()
                .orElseThrow(() -> new BusinessException("No hay configuración del taller cargada"));

        LocalDateTime fechaHora = request.fechaHoraIngreso();

        // Validar horario
        if (fechaHora.toLocalTime().isBefore(config.getHorarioApertura()) ||
                fechaHora.toLocalTime().isAfter(config.getHorarioCierre())) {
            throw new BusinessException("El horario está fuera del horario de atención del taller");
        }

        // Validar día hábil
        String diaSemana = fechaHora.getDayOfWeek().toString();
        List<String> diasHabiles = Arrays.asList(config.getDiasTrabajo().split(","));
        if (!diasHabiles.contains(diaSemana)) {
            throw new BusinessException("El taller no atiende ese día");
        }

        // Validar disponibilidad
        int duracion = request.duracionAprox() != null ? request.duracionAprox() : 60;
        LocalDateTime fin = fechaHora.plusMinutes(duracion);
        long solapados = turnoRepository.contarTurnosSolapados(fechaHora, fin);
        if (solapados >= config.getCapacidadSimultanea()) {
            throw new BusinessException("No hay disponibilidad en ese horario");
        }

        Turno turno = Turno.builder()
                .cliente(request.clienteId() != null
                        ? clienteRepository.findById(request.clienteId())
                        .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"))
                        : null)
                .vehiculo(vehiculoRepository.findById(request.vehiculoId())
                        .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado")))
                .creadoPor(usuarioRepository.findByUsername(usernameCreador)
                        .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado")))
                .fechaHoraIngreso(fechaHora)
                .duracionAprox(duracion)
                .estado(EstadoTurno.PENDIENTE)
                .descripcion(request.descripcion())
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
                turnoRepository.findByFechaHoraIngresoBetween(
                        fecha.atStartOfDay(), fecha.atTime(23, 59, 59)));
    }

    @Override
    @Transactional
    public TurnoResponse cambiarEstado(Long id, EstadoTurno nuevoEstado) {
        Turno turno = findById(id);
        validarTransicion(turno.getEstado(), nuevoEstado);
        turno.setEstado(nuevoEstado);
        return turnoMapper.toResponse(turnoRepository.save(turno));
    }

    @Override
    @Transactional
    public void cancelar(Long id) {
        Turno turno = findById(id);
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

    private Turno findById(Long id) {
        return turnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Turno no encontrado con id: " + id));
    }
}
*/
 
}
