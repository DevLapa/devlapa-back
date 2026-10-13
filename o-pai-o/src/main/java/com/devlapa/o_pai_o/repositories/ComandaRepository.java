package com.devlapa.o_pai_o.repositories;

import com.devlapa.o_pai_o.domain.comandas.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {
}
