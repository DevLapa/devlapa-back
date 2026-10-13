package com.devlapa.o_pai_o.repositories;

import com.devlapa.o_pai_o.domain.contas.ContaPagar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasPagarRepository extends JpaRepository<ContaPagar, Long> {

}
