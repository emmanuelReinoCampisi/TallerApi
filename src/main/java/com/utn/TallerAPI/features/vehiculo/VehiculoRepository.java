package com.utn.TallerAPI.features.vehiculo;

import com.utn.TallerAPI.features.vehiculo.dto.VehiculoResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<VehiculoResponse,Long> {
    Optional<VehiculoEntity> findByPatenteId(String patenteId);
    boolean existsByPatente(String patente);
    List<VehiculoEntity> findByClienteId(Long clienteId);
    List<VehiculoEntity>findByEstadoEnTaller(String estadoEnTaller);
    VehiculoEntity save(VehiculoEntity vehiculoEntity);
    Optional<VehiculoEntity> findById(Long id);
}
