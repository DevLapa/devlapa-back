package com.devlapa.o_pai_o.domain.comandas;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ItemRequestDTO(
        @NotNull(message = "ID do produto é obrigatório")
        Long produtoId,

        @NotNull(message = "A quantidade é obrigatória")
        @Min(value = 1, message = "A quantidade mínima permitida é 1")
        Integer quantidade
) {}