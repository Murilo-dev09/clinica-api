package com.clinicaapi.clinica.service;

import com.clinicaapi.clinica.model.paciente.DadosAtualizacaoPaciente;
import com.clinicaapi.clinica.model.paciente.DadosCadastroPaciente;
import com.clinicaapi.clinica.model.paciente.DadosListagemPaciente;
import com.clinicaapi.clinica.model.paciente.Paciente;
import com.clinicaapi.clinica.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Transactional
    public Paciente cadastrar(DadosCadastroPaciente dados){
        var paciente = new Paciente(dados);
        repository.save(paciente);
        return paciente;
    }

    public Page<DadosListagemPaciente> listar(Pageable paginacao){
        return repository .findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @Transactional
    public Paciente atualizar(DadosAtualizacaoPaciente dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
        return paciente;
    }

    @Transactional
    public void excluir(Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }

    public Paciente detalhar(Long id){
        return repository.getReferenceById(id);
    }
}
