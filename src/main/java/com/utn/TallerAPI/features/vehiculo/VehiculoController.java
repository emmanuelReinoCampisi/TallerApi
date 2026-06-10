package com.utn.TallerAPI.features.vehiculo;

import com.utn.TallerAPI.features.vehiculo.dto.VehiculoRequest;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
@Tag(name = "Vehículos", description = "Gestión de vehículos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @PostMapping
    @Operation(summary = "Crear vehículo")
    public ResponseEntity<VehiculoResponse> crear(@Valid @RequestBody VehiculoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoService.crear(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener vehículo por ID")
    public ResponseEntity<VehiculoResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoService.obtenerPorId(id));
    }

    @GetMapping
    @Operation(summary = "Listar vehículos paginados")
    public ResponseEntity<Page<VehiculoResponse>> listar(Pageable pageable) {
        return ResponseEntity.ok(vehiculoService.listarTodos(pageable));
    }

    @GetMapping("/cliente/{clienteId}")
    @Operation(summary = "Listar vehículos por cliente")
    public ResponseEntity<List<VehiculoResponse>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(vehiculoService.listarPorCliente(clienteId));
    }

    @PutMapping("/{patente}")
    @Operation(summary = "Actualizar vehículo")
    public ResponseEntity<VehiculoResponse> actualizar(@PathVariable String patente, @Valid @RequestBody VehiculoRequest request) {
        return ResponseEntity.ok(vehiculoService.actualizar(patente, request));
    }

    @PatchMapping("/{id}/estado")
    @Operation(summary = "Actualizar estado del vehículo")
    public ResponseEntity<VehiculoResponse> actualizarEstado(@PathVariable Long id, @RequestParam EstadoVehiculo nuevoEstado) {
        return ResponseEntity.ok(vehiculoService.actualizarEstado(id, nuevoEstado));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar vehículo")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        vehiculoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}