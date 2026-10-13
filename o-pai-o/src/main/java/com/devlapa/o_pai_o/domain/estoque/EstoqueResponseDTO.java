package com.devlapa.o_pai_o.domain.estoque;

import java.time.LocalDateTime;

public record EstoqueResponseDTO(
        Long id,
        String nomeProduto,
        Integer quantidade,
        Integer minimo,
        StatusEstoque status,
        LocalDateTime dataUltimaMovimentacao
) {

    public EstoqueResponseDTO(Estoque estoque) {
        this(
                estoque.getId(),
                estoque.getProduto().getNome(),
                estoque.getQuantidade(),
                estoque.getMinimo(),
                estoque.getStatus(),
                estoque.getDataModificacao() != null ? estoque.getDataModificacao() : estoque.getDataCadastro()
        );
    }
}