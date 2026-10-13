package com.devlapa.o_pai_o.domain.fornecedores;

public record FornecedoresRequestDTO(
        String nome,
        String cnpj,
        String telefone,
        String email,
        String endereco) {
}
