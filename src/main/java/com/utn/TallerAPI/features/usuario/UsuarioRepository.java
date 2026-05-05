package com.utn.TallerAPI.features.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {

    Optional<UsuarioEntity> findByEmail(String email);
    Optional<UsuarioEntity> findByUserName(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
