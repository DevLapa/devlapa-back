package com.devlapa.o_pai_o.domain.estoque;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EstoquePatchDTO(
        @NotNull @Positive Integer quantidade
) {}