package com.devlapa.o_pai_o.domain.comandas;

import java.math.BigDecimal;

public record ComandaResponseDTO(
        Long id,
        Integer numeroMesa,
        String nomeCliente,
        String status,
        BigDecimal valorTotal
) {
    public ComandaResponseDTO(Comanda comanda) {
        this(
                comanda.getId(),
                comanda.getNumeroMesa(),
                comanda.getNomeCliente(),
                comanda.getStatus().toString(),
                comanda.getValorTotal()
        );
    }
}