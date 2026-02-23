package com.clinicaapi.clinica.endereco;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DadosEndereco(
        @NotBlank(message = "Logradouro não pode ser vazio.")
        String logradouro,

        @NotBlank(message = "Bairro não pode ser vazio.")
        String bairro,

        @NotBlank(message = "Cep não pode ser vazio.")
        @Pattern(regexp = "\\d{8}", message = "Cep só pode conter 8 dígitos.")
        String cep,

        @NotBlank(message = "Cidade não pode ser vazio.")
        String cidade,

        @NotBlank(message = "Uf não pode ser vazio.")
        String uf,

        @NotBlank(message = "Numero não pode ser vazio.")
        String numero,

        String complemento
) {
}
