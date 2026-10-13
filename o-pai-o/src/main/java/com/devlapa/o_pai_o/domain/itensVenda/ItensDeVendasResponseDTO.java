package com.devlapa.o_pai_o.domain.itensVenda;

import com.devlapa.o_pai_o.domain.produtos.Produtos;
import com.devlapa.o_pai_o.domain.vendas.Vendas;

import java.math.BigDecimal;

public record ItensDeVendasResponseDTO(
        Long id,
        Produtos produtos,
        Integer quantidade,
        BigDecimal precoUnitario,
        BigDecimal precoTotal
) {
}
