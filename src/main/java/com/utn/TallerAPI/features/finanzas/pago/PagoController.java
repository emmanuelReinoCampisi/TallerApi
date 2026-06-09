package com.utn.TallerAPI.features.finanzas.pago;

import com.utn.TallerAPI.features.finanzas.pago.dto.PagoRequest;
import com.utn.TallerAPI.features.finanzas.pago.dto.PagoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
@Tag(name = "Pagos", description = "Gestión de pagos")
public class PagoController {

    private final PagoService pagoService;

    @PostMapping
    @Operation(summary = "Registrar pago")
    public ResponseEntity<PagoResponse> registrar(@Valid @RequestBody PagoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.registrarPago(request));
    }

    @GetMapping("/cliente/{clienteId}")
    @Operation(summary = "Listar pagos por cliente")
    public ResponseEntity<List<PagoResponse>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(pagoService.obtenerPagosPorCliente(clienteId));
    }
}