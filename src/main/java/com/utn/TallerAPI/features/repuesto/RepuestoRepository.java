package com.utn.TallerAPI.features.repuesto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepuestoRepository extends JpaRepository<RepuestoEntity,Long> {

    Optional<RepuestoEntity> findByCodigoRepuesto(String codigo);
    boolean existsByCodigoRepuesto(String codigo);

    @Query("SELECT r from RepuestoEntity r where r.stockActual <= r.stockMinimo")
    List<RepuestoEntity> findBajoStock();


}

