package com.clinicaapi.clinica.service;

import com.clinicaapi.clinica.model.medico.DadosAtualizacaoMedico;
import com.clinicaapi.clinica.model.medico.DadosCadastroMedico;
import com.clinicaapi.clinica.model.medico.DadosListagemMedico;
import com.clinicaapi.clinica.model.medico.Medico;
import com.clinicaapi.clinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    public Medico cadastrar (DadosCadastroMedico dados){
        var medico = new Medico(dados);
        repository.save(medico);
        return medico;
    }

    public Page<DadosListagemMedico> listar(Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @Transactional
    public Medico atualizar (DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return medico;
    }

    @Transactional
    public void excluir(Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

    public Medico detalhar(Long id){
        return repository.getReferenceById(id);
    }
}
