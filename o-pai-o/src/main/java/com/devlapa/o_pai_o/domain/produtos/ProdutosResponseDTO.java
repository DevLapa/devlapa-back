package com.devlapa.o_pai_o.domain.produtos;

import com.devlapa.o_pai_o.domain.categorias.Categorias;
import com.devlapa.o_pai_o.domain.fornecedores.Fornecedores;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProdutosResponseDTO(
        Long id,
        String nome,
        BigDecimal preco,
        String unidade,
        Categorias categoria,
        Fornecedores fornecedor,
        Boolean ativo,
        LocalDateTime datacricao
) {}
