package com.utn.TallerAPI.features.finanzas.deuda;

import com.utn.TallerAPI.features.finanzas.deuda.dto.DeudaRequest;
import com.utn.TallerAPI.features.finanzas.deuda.dto.DeudaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deudas")
@RequiredArgsConstructor
@Tag(name = "Deudas", description = "Gestión de deudas")
public class DeudaController {

    private final DeudaService deudaService;

    @GetMapping("/cliente/{clienteId}")
    @Operation(summary = "Obtener deuda por cliente")
    public ResponseEntity<DeudaResponse> obtenerPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(deudaService.obtenerPorClienteId(clienteId));
    }

    @PatchMapping
    @Operation(summary = "Ajustar deuda manualmente")
    public ResponseEntity<DeudaResponse> ajustar(@Valid @RequestBody DeudaRequest request) {
        return ResponseEntity.ok(deudaService.ajustarDeudaManualmente(request));
    }
}