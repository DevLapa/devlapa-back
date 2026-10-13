package com.devlapa.o_pai_o.domain.formasPagamentos;

public record FormasPagamentoResponseDTO(Long id, String nome, String descricao, String tipo, boolean permitirParcelamento, boolean ativo,java.time.LocalDateTime data_criacao, java.time.LocalDateTime data_mocificacao) {
}
