package com.utn.TallerAPI.features.turno;

import com.utn.TallerAPI.features.turno.dto.TurnoRequest;
import com.utn.TallerAPI.features.turno.dto.TurnoResponse;
import com.utn.TallerAPI.features.vehiculo.EstadoVehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface TurnoService {

    TurnoResponse crear(TurnoRequest turnoRequest,String nombreCreador);
    TurnoResponse obtenerPorId(Long id);
    Page<TurnoResponse> listarTodos(Pageable page);
    List<TurnoResponse> listarPorClienteId(Long clienteId);
    List<TurnoResponse> listarPorFecha(LocalDate fecha);
    TurnoResponse actualizar(TurnoRequest turnoRequest, EstadoTurno estado);
    void cancelar(Long id);

}
