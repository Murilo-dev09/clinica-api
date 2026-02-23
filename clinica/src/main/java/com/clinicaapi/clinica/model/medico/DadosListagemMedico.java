package com.clinicaapi.clinica.model.medico;

public record DadosListagemMedico(Long id, String nome, String crm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(),  medico.getCrm(), medico.getEspecialidade());
    }
}
