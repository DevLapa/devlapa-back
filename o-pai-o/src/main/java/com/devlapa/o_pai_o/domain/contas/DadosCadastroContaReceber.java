package com.devlapa.o_pai_o.domain.contas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosCadastroContaReceber(
        @NotNull Long usuarioId,
        @NotBlank String cliente,
        @NotBlank String descricao,
        @NotNull @Positive BigDecimal valor,
        @NotNull LocalDate dataVencimento,
        LocalDate dataRecebimento,
        LocalDateTime dataCriacao
) { }
