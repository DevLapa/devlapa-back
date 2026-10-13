package com.devlapa.o_pai_o.repositories;

import com.devlapa.o_pai_o.domain.movimentacao.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    List<Movimentacao> findByEstoqueIdOrderByDataHoraDesc(Long estoqueId);
}
