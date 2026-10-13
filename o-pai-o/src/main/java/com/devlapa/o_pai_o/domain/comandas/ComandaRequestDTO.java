package com.devlapa.o_pai_o.domain.comandas;

import jakarta.validation.constraints.NotNull;

public record ComandaRequestDTO(
        @NotNull(message = "O número da mesa é obrigatório")
        Integer numeroMesa,

        String nomeCliente
) {}