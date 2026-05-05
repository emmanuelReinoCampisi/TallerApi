package com.utn.TallerAPI.features.Mecanico.Controller;

import com.utn.TallerAPI.features.Mecanico.DTO.EspecialidadRequest;
import com.utn.TallerAPI.features.Mecanico.DTO.EspecialidadResponse;
import com.utn.TallerAPI.features.Mecanico.Especialidad;
import com.utn.TallerAPI.features.Mecanico.EspecialidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
@Tag(name = "Especialidades", description = "Gestion de especialidades de mecanicos")
public class EspecialidadController {

        private final EspecialidadService especialidadService;

        public EspecialidadController(EspecialidadService especialidadService) {
            this.especialidadService = especialidadService;
        }


    @GetMapping
    @Operation(summary = "Listar especialidades")
    public ResponseEntity<List<EspecialidadResponse>> listar() {
        return ResponseEntity.ok(especialidadService.listarTodas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener especialidad por id")
    public ResponseEntity<EspecialidadResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(especialidadService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear especialidad")
    public ResponseEntity<EspecialidadResponse> crear(@Valid @RequestBody EspecialidadRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadService.crear(request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar especialidad")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        especialidadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
