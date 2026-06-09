package com.utn.TallerAPI.features.turno;

import com.utn.TallerAPI.features.turno.dto.TurnoRequest;
import com.utn.TallerAPI.features.turno.dto.TurnoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/turnos")
@RequiredArgsConstructor
@Tag(name = "Turnos", description = "Gestión de turnos")
public class TurnoController {

    private final TurnoService turnoService;

    @PostMapping
    @Operation(summary = "Crear turno")
    public ResponseEntity<TurnoResponse> crear(@Valid @RequestBody TurnoRequest request,
                                               @RequestHeader("X-Username") String username) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoService.crear(request, username));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener turno por ID")
    public ResponseEntity<TurnoResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(turnoService.obtenerPorId(id));
    }

    @GetMapping
    @Operation(summary = "Listar turnos paginados")
    public ResponseEntity<Page<TurnoResponse>> listar(Pageable pageable) {
        return ResponseEntity.ok(turnoService.listarTodos(pageable));
    }

    @GetMapping("/cliente/{clienteId}")
    @Operation(summary = "Listar turnos por cliente")
    public ResponseEntity<List<TurnoResponse>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(turnoService.listarPorCliente(clienteId));
    }

    @GetMapping("/fecha/{fecha}")
    @Operation(summary = "Listar turnos por fecha")
    public ResponseEntity<List<TurnoResponse>> listarPorFecha(@PathVariable LocalDate fecha) {
        return ResponseEntity.ok(turnoService.listarPorFecha(fecha));
    }

    @PutMapping("/{id}/estado")
    @Operation(summary = "Cambiar estado del turno")
    public ResponseEntity<TurnoResponse> cambiarEstado(@PathVariable Long id, @RequestParam EstadoTurno nuevoEstado) {
        return ResponseEntity.ok(turnoService.cambiarEstado(id, nuevoEstado));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancelar turno")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        turnoService.cancelar(id);
        return ResponseEntity.noContent().build();
    }
}