
package com.clinicaapi.clinica.controller;

import com.clinicaapi.clinica.model.consulta.Consulta;
import com.clinicaapi.clinica.model.consulta.DadosAgendamentoConsulta;
import com.clinicaapi.clinica.model.consulta.DadosListagemConsulta;
import com.clinicaapi.clinica.service.ConsultaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public Consulta agendar(@RequestBody DadosAgendamentoConsulta dados) {
        return service.agendar(dados);
    }

    @PutMapping("/{id}/cancelar")
    public void cancelar(@PathVariable Long id) {
        service.cancelar(id);
    }

    @PutMapping("/atualizar-status")
    public void atualizarStatus() {
        service.atualizarConsultasFinalizadas();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemConsulta>> listar(@PageableDefault(size = 10, sort = {"data"}) Pageable paginacao){
        var pagina = service.listarAgendadas(paginacao);
        return ResponseEntity.ok(pagina);
    }
}
