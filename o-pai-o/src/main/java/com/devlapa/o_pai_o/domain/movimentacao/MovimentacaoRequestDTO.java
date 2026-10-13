package com.devlapa.o_pai_o.domain.movimentacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MovimentacaoRequestDTO(
        @NotNull Long estoqueId,
        @NotNull @Positive Integer quantidade,
        @NotNull TipoMovimentacao tipo,
        @NotBlank String motivo
) {}
