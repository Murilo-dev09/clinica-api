package com.clinicaapi.clinica.model.consulta;

import com.clinicaapi.clinica.model.medico.Medico;
import com.clinicaapi.clinica.model.paciente.Paciente;

import java.time.LocalDateTime;

public record DadosListagemConsulta(
        Long id,
        String medicoNome,
        String pacienteNome,
        LocalDateTime data
) {
    public DadosListagemConsulta(Consulta consulta){
        this(consulta.getId(), consulta.getMedico().getNome(),consulta.getPaciente().getNome(), consulta.getData());
    }


}