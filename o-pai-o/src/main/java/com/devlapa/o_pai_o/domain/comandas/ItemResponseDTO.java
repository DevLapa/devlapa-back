package com.devlapa.o_pai_o.domain.comandas;

import java.math.BigDecimal;

public record ItemResponseDTO(
        Long id,
        String nomeProduto,
        Integer quantidade,
        BigDecimal precoUnitario,
        BigDecimal subtotal
) {
    public ItemResponseDTO(ItemComanda item) {
        this(
                item.getId(),
                item.getProdutos().getNome(),
                item.getQuantidade(),
                item.getPrecoUnitario(),
                item.getSubtotal()
        );
    }
}