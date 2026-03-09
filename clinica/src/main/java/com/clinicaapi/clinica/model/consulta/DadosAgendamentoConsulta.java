package com.clinicaapi.clinica.model.consulta;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        Long medicoId,
        Long pacienteId,
        LocalDateTime data
) {
}
