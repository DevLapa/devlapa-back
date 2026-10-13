package com.devlapa.o_pai_o.domain.contas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ContasReceberResponseDTO(
        Long id,
        String cliente,
        String descricao,
        BigDecimal valor,
        LocalDate dataVencimento,
        LocalDate dataRecebimento,
        LocalDateTime dataCriacao,
        String status,
        Long userCriacaoId,
        Long comandaId
) {
    public ContasReceberResponseDTO(ContasReceber conta) {
        this(
                conta.getId(),
                conta.getCliente(),
                conta.getDescricao(),
                conta.getValor(),
                conta.getDataVencimento(),
                conta.getDataRecebimento(),
                conta.getDatacriacao(),
                conta.getStatus() != null ? conta.getStatus().name() : null,
                conta.getUserCriacao() != null ? conta.getUserCriacao().getId() : null,
                conta.getComanda() != null ? conta.getComanda().getId() : null
        );
    }
}
