package com.utn.TallerAPI.features.turno;

import com.utn.TallerAPI.features.turno.dto.TurnoRequest;
import com.utn.TallerAPI.features.turno.dto.TurnoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface TurnoService {

    TurnoResponse crear(TurnoRequest request, String usernameCreador);
    TurnoResponse obtenerPorId(Long id);
    Page<TurnoResponse> listarTodos(Pageable pageable);
    List<TurnoResponse> listarPorCliente(Long clienteId);
    List<TurnoResponse> listarPorFecha(LocalDate fecha);
    TurnoResponse cambiarEstado(Long id, EstadoTurno nuevoEstado);
    void cancelar(Long id);
}