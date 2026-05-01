package com.utn.TallerAPI.features.mecanico.Controller;

import com.utn.TallerAPI.features.mecanico.dto.MecanicoRequest;
import com.utn.TallerAPI.features.mecanico.dto.MecanicoResponse;
import com.utn.TallerAPI.features.mecanico.MecanicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mecanicos")
@RequiredArgsConstructor
@Tag(name = "Mecánicos", description = "Gestión de mecánicos y especialidades")
@SecurityRequirement(name = "bearerAuth")

public class MecanicoController {

    private final MecanicoService mecanicoService;

    @PostMapping
    @Operation(summary = "Crear mecánico")
    public ResponseEntity<MecanicoResponse> crear(@Valid @RequestBody MecanicoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mecanicoService.crear(request));
    }

    @GetMapping
    @Operation(summary = "Listar mecánicos activos")
    public ResponseEntity<List<MecanicoResponse>> listar() {
        return ResponseEntity.ok(mecanicoService.listarActivos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener mecánico por ID")
    public ResponseEntity<MecanicoResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(mecanicoService.obtenerPorId(id));
    }



}
