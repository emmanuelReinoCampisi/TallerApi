package com.utn.TallerAPI.features.finanzas.pago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity,Integer> {

    Optional<PagoEntity> findByClienteId(Long ClienteId);
}
