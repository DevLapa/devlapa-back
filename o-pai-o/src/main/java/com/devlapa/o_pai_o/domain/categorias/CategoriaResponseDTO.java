package com.devlapa.o_pai_o.domain.categorias;

public record CategoriaResponseDTO(
        Long id,
        String nome,
        String descricao,
        java.time.LocalDateTime data_cadastro
) {
}
