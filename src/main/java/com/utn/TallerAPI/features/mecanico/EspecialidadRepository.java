package com.utn.TallerAPI.features.mecanico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {

    boolean existsByNombreEspecialidad(String nombre);
    Optional<Especialidad> findByNombreEspecialidad(String nombre);
    Optional<Especialidad> findById(Long id);

    @Query("SELECT e FROM Especialidad e WHERE e.id IN :ids")
    List<Especialidad> findAllByIdIn(List<Long> ids);
}
