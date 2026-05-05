package com.utn.TallerAPI.features.orden.Controller;


import com.utn.TallerAPI.features.orden.OrdenService;
import com.utn.TallerAPI.features.orden.dto.CambioEstadoRequest;
import com.utn.TallerAPI.features.orden.dto.DetalleOrdenRequest;
import com.utn.TallerAPI.features.orden.dto.OrdenMecanicoRequest;
import com.utn.TallerAPI.features.orden.dto.OrdenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
@Tag(name = "Ordenes", description = "Gestion de ordenes de trabajo")
public class OrdenController {

    private final OrdenService ordenService;
    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping("/turno/{turnoId}")
    @Operation(summary = "Abrir orden para turno")
    public ResponseEntity<OrdenResponse> abrir(@PathVariable Long turnoId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenService.abrir(turnoId));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener orden por id")
    public ResponseEntity<OrdenResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(ordenService.obtenerPorId(id));
    }


    @GetMapping("/cliente/{clienteId}")
    @Operation(summary = "Listar ordenes por cliente")
    public ResponseEntity<List<OrdenResponse>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(ordenService.listarPorCliente(clienteId));
    }

    @GetMapping("/vehiculo/{vehiculoId}")
    @Operation(summary = "Listar ordenes por vehiculo")
    public ResponseEntity<List<OrdenResponse>> listarPorVehiculo(@PathVariable Long vehiculoId) {
        return ResponseEntity.ok(ordenService.listarPorVehiculo(vehiculoId));
    }

    @PutMapping("/{id}/estado")
    @Operation(summary = "Cambiar estado de orden")
    public ResponseEntity<OrdenResponse> cambiarEstado(
            @PathVariable Long id,
            @Valid @RequestBody CambioEstadoRequest request
    ) {
        return ResponseEntity.ok(ordenService.cambiarEstado(id, request.nuevoEstado()));
    }


    @PostMapping("/{id}/detalles")
    @Operation(summary = "Agregar detalle a orden")
    public ResponseEntity<OrdenResponse> agregarDetalle(
            @PathVariable Long id,
            @Valid @RequestBody DetalleOrdenRequest request
    ) {
        return ResponseEntity.ok(ordenService.agregarDetalle(id, request));
    }

    @PostMapping("/{id}/mecanicos")
    @Operation(summary = "Asignar mecanico a orden")
    public ResponseEntity<OrdenResponse> asignarMecanico(
            @PathVariable Long id,
            @Valid @RequestBody OrdenMecanicoRequest request
    ) {
        return ResponseEntity.ok(ordenService.asignarMecanico(id, request));
    }

    @PostMapping("/{id}/cerrar")
    @Operation(summary = "Cerrar orden")
    public ResponseEntity<OrdenResponse> cerrar(@PathVariable Long id) {
        return ResponseEntity.ok(ordenService.cerrar(id));
    }

}
