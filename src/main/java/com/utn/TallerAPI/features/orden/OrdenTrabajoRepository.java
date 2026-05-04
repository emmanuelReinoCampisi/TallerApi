package com.utn.TallerAPI.features.orden;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdenTrabajoRepository extends JpaRepository<OrdenMecanico, Long> {
    Optional<OrdenTrabajo> findByTurnoId(Long turnoId);

    List<OrdenTrabajo> findByEstado(EstadoOrden estado);

    List<OrdenTrabajo> findByTurno_Cliente_Id(Long clienteId);

    List<OrdenTrabajo> findByTurno_Vehiculo_Id(Long vehiculoId);
}
