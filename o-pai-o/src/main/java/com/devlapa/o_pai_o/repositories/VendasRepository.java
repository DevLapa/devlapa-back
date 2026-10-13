package com.devlapa.o_pai_o.repositories;

import com.devlapa.o_pai_o.domain.vendas.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository<Vendas, Long> {
}
