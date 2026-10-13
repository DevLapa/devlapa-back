package com.devlapa.o_pai_o.domain.movimentacao;

import java.time.LocalDateTime;

public record MovimentacaoResponseDTO(
        Long id,
        Long estoqueId,
        String produtoNome,
        Integer quantidade,
        TipoMovimentacao tipo,
        String motivo,
        String usuarioResponsalvel,
        LocalDateTime dataHora
) {

    public MovimentacaoResponseDTO(Movimentacao m) {
        this(
                m.getId(),
                m.getEstoque().getId(),
                m.getEstoque().getProduto().getNome(),
                m.getQuantidade(),
                m.getTipo(),
                m.getMotivo(),
                m.getUsuarioResponsavel(),
                m.getDataHora()
        );
    }
}
