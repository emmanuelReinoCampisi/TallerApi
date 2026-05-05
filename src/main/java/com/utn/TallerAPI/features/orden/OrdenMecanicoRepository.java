package com.utn.TallerAPI.features.orden;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenMecanicoRepository extends JpaRepository<OrdenMecanico, Long> {
    List<OrdenMecanico> findByOrdenId(Long ordenId);

    List<OrdenMecanico> findByMecanicoId(Long mecanicoId);
}
