package com.devlapa.o_pai_o.domain.fornecedores;

public record FornecedoresResponseDTO (
        Long id,
        String nome,
        String cnpj,
        String telefone,
        String email,
        String endereco,
        boolean ativo,
        java.time.LocalDateTime date_cadastro
        ) {
}
