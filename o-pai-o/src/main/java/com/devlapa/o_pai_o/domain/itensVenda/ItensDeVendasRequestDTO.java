package com.devlapa.o_pai_o.domain.itensVenda;

import java.math.BigDecimal;

public record ItensDeVendasRequestDTO(
        Long vendaId,
        Long produtoId,
        Integer quantidade,
        BigDecimal precoUnitario
) {
}
