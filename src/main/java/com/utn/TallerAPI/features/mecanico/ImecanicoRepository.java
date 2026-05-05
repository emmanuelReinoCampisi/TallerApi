package com.utn.TallerAPI.features.mecanico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ImecanicoRepository extends JpaRepository<MecanicoEntity, Long> {

    Optional<MecanicoEntity> findByUsuarioId(Long usuarioId);
    List<MecanicoEntity> findByEspecialidadesId(Long especialidadId);
    @Query("SELECT m FROM MecanicoEntity m WHERE m.activo = true")
    List<MecanicoEntity> findAllActivos();
     Optional<MecanicoEntity> findByLegajo(String legajo);
    boolean existsByLegajo(String legajo);

}
