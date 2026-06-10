package com.utn.TallerAPI.features.vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {
    Optional<VehiculoEntity> findByPatente(String patente);
    boolean existsByPatente(String patente);
    List<VehiculoEntity> findByClienteId(Long clienteId);
    List<VehiculoEntity> findByEstado(EstadoVehiculo estado);
}