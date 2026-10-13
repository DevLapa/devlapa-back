package com.devlapa.o_pai_o.repositories;

import com.devlapa.o_pai_o.domain.contas.ContasReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasReceberRepository extends JpaRepository <ContasReceber, Long> {
}
