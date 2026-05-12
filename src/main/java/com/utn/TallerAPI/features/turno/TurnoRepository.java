package com.utn.TallerAPI.features.turno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TurnoRepository {

    List<TurnoEntity> findByClienteId(Long clienteId);
    List<TurnoEntity> findByFechayHoraIngreso(LocalDateTime fechayHora);

    @Query("SELECT COUNT(t) FROM TurnoEntity t WHERE " +
            "t.fechaYhoraIngreso < :end AND " +
            "FUNCTION('TIMESTAMPADD', 'MINUTE', t.fechaYhoraSalida, t.fechaYhoraIngreso) > :start")
    long contarTurnosSolapados(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    Page<TurnoEntity> findAll(Pageable pageable);
}
