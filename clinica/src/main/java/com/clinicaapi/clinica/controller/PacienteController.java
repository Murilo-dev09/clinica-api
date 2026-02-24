package com.clinicaapi.clinica.controller;

import com.clinicaapi.clinica.model.paciente.DadosAtualizacaoPaciente;
import com.clinicaapi.clinica.model.paciente.DadosCadastroPaciente;
import com.clinicaapi.clinica.model.paciente.DadosDetalhamentoPaciente;
import com.clinicaapi.clinica.model.paciente.DadosListagemPaciente;
import com.clinicaapi.clinica.service.PacienteService;
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
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoPaciente> cadastrar(@RequestBody @Valid DadosCadastroPaciente dados,
                                                               UriComponentsBuilder uriBuilder){
        var paciente = service.cadastrar(dados);
        var uri = uriBuilder
                .path("/paciente{id}")
                .buildAndExpand(paciente.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(new DadosDetalhamentoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(size = 10, sort = {"nome"})
                                                                  Pageable paginacao){
        return ResponseEntity.ok(service.listar(paginacao));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoPaciente> atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){
        var paciente = service.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPaciente> detalhar(@PathVariable Long id){
        var paciente = service.detalhar(id);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
}
