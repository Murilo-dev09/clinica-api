package com.clinicaapi.clinica.service;

import com.clinicaapi.clinica.model.consulta.*;
import com.clinicaapi.clinica.model.medico.DadosListagemMedico;
import com.clinicaapi.clinica.model.medico.Medico;
import com.clinicaapi.clinica.model.paciente.DadosListagemPaciente;
import com.clinicaapi.clinica.model.paciente.Paciente;
import com.clinicaapi.clinica.repository.ConsultaRepository;
import com.clinicaapi.clinica.repository.MedicoRepository;
import com.clinicaapi.clinica.repository.PacienteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    @Autowired
    private final ConsultaRepository consultaRepository;

    @Autowired
    private final MedicoRepository medicoRepository;

    @Autowired
    private final PacienteRepository pacienteRepository;

    public Consulta agendar(DadosAgendamentoConsulta dados) {

        if (dados.data().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Não é possível agendar consulta no passado.");
        }

        if (consultaRepository.existsByMedicoIdAndDataAndStatus(
                dados.medicoId(),
                dados.data(),
                StatusConsulta.AGENDADA)) {

            throw new RuntimeException("Médico já possui consulta nesse horário.");
        }

        Medico medico = medicoRepository.findById(dados.medicoId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado."));

        Paciente paciente = pacienteRepository.findById(dados.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado."));

        Consulta consulta = new Consulta(medico, paciente, dados.data());

        return consultaRepository.save(consulta);
    }

    public void cancelar(Long id) {

        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada."));

        if (consulta.getStatus() == StatusConsulta.CANCELADA) {
            throw new RuntimeException("Consulta já está cancelada.");
        }

        if (consulta.getStatus() == StatusConsulta.REALIZADA) {
            throw new RuntimeException("Consulta já foi realizada.");
        }

        consulta.setStatus(StatusConsulta.CANCELADA);
        consultaRepository.save(consulta);
    }

    public void atualizarConsultasFinalizadas() {

        List<Consulta> consultas = consultaRepository.findByStatus(StatusConsulta.AGENDADA);

        for (Consulta consulta : consultas) {
            if (consulta.getData().isBefore(LocalDateTime.now())) {
                consulta.setStatus(StatusConsulta.REALIZADA);
            }
        }

        consultaRepository.saveAll(consultas);
    }

    public Page<DadosListagemConsulta> listarAgendadas(Pageable paginacao) {

        return consultaRepository.findAllByStatus(StatusConsulta.AGENDADA, paginacao)
                .map(DadosListagemConsulta::new);
    }

    public Page<DadosListagemConsulta> listarRealizadas(Pageable paginacao) {

        return consultaRepository.findAllByStatus(StatusConsulta.REALIZADA, paginacao)
                .map(DadosListagemConsulta::new);
    }
}

