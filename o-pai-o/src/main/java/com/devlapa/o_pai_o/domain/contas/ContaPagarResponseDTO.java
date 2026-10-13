package com.devlapa.o_pai_o.domain.contas;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContaPagarResponseDTO(
        Long id,
        Long fornecedorId,
        Long userCriacaoId,
        String descricao,
        BigDecimal valor,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        String categoria,
        String status
) {
    public ContaPagarResponseDTO(ContaPagar conta) {
        this(
                conta.getId(),
                conta.getFornecedor() != null ? conta.getFornecedor().getId() : null,
                conta.getUserCriacao() != null ? conta.getUserCriacao().getId() : null,
                conta.getDescricao(),
                conta.getValor(),
                conta.getDataVencimento(),
                conta.getDataPagamento(),
                conta.getCategoria(),
                conta.getStatus() != null ? conta.getStatus().name() : null
        );
    }
}
