package com.utn.TallerAPI.features.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer> {

    boolean existsByUsuarioId(Long id);

    Optional<ClienteEntity> findByUsuarioId(Long id);


}
