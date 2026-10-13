package com.devlapa.o_pai_o.domain.vendas;

import java.math.BigDecimal;

public record VendasRequestDTO(Long formasPagamentosId, BigDecimal valor_total, StatusVenda statusVenda) {
}
