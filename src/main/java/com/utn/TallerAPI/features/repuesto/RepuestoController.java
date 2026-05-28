package com.utn.TallerAPI.features.repuesto;

import com.utn.TallerAPI.features.repuesto.dto.RepuestoRequest;
import com.utn.TallerAPI.features.repuesto.dto.RepuestoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
@RequiredArgsConstructor
public class RepuestoController {

    private  RepuestoService repuestoService;

    @PostMapping
    public ResponseEntity<RepuestoResponse> registrarRepuesto(@Valid @RequestBody RepuestoRequest request){

        return ResponseEntity.status(HttpStatus.CREATED).body(repuestoService.registrar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepuestoResponse> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(repuestoService.obtenerPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<RepuestoResponse>> listarTodos(){
        return ResponseEntity.ok(repuestoService.listarTodos());
    }

    @GetMapping("/{bajo-sotck}")
    public ResponseEntity<List<RepuestoResponse>> listarBajoStock(){
        return ResponseEntity.ok(repuestoService.listarBajoStock());
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<RepuestoResponse> actualizarStock(@PathVariable Long id, @RequestParam Integer cantidad){
        return ResponseEntity.ok(repuestoService.actualizarStock(id,cantidad));
    }

}
