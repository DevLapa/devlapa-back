package com.devlapa.o_pai_o.domain.contas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroContaPagar(
        @NotNull Long usuarioId,
        @NotNull Long fornecedorId,
        @NotBlank String descricao,
        @NotNull @Positive BigDecimal valor,
        @NotNull LocalDate dataVencimento,
        @NotBlank String categoria
) { }
