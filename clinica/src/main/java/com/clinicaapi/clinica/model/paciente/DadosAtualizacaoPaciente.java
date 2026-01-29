package com.clinicaapi.clinica.model.paciente;

import com.clinicaapi.clinica.endereco.DadosEndereco;
import com.clinicaapi.clinica.endereco.Endereco;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
