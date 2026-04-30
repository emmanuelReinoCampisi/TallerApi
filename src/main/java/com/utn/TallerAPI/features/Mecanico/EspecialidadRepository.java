package com.utn.TallerAPI.features.Mecanico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {

    boolean existsByNombre(String nombre);
    Optional<Especialidad> findByNombre(String nombre);
    Optional<Especialidad> findById(Long id);
    List<Especialidad> findAllIds(List<Long> ids);

}
