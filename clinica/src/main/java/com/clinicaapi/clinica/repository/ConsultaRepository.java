package com.clinicaapi.clinica.repository;

import com.clinicaapi.clinica.model.consulta.Consulta;
import com.clinicaapi.clinica.model.consulta.StatusConsulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByMedicoIdAndDataAndStatus(
            Long medicoId,
            LocalDateTime data,
            StatusConsulta status
    );
    List<Consulta> findByStatus(StatusConsulta status);

    Page<Consulta> findAllByStatus(StatusConsulta status, Pageable paginacao);
}