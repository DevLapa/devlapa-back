package com.devlapa.o_pai_o.domain.produtos;

import java.math.BigDecimal;


public record ProdutosRequestDTO(
    String nome,
    BigDecimal preco,
    String unidade,
    Long categoriaId,
    Long fornecedoresId
) { }


