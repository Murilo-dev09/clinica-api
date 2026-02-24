package com.clinicaapi.clinica.controller;

import com.clinicaapi.clinica.model.medico.DadosAtualizacaoMedico;
import com.clinicaapi.clinica.model.medico.DadosCadastroMedico;
import com.clinicaapi.clinica.model.medico.DadosDetalhamentoMedico;
import com.clinicaapi.clinica.model.medico.DadosListagemMedico;
import com.clinicaapi.clinica.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoMedico> cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        var medico = service.cadastrar(dados);
        var uri = uriBuilder.
                path("medico/{id}")
                .buildAndExpand(medico.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return ResponseEntity.ok(service.listar(paginacao));

    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoMedico> atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = service.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoMedico> detalhar(@PathVariable Long id){
        var medico = service.detalhar(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
}
