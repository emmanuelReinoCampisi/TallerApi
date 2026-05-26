package com.utn.TallerAPI.features.finanzas.deuda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeudaRepository extends JpaRepository<DeudaEntity,Integer> {

    Optional<DeudaEntity> findByClienteId(Long ClienteId);
}
