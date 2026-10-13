package com.devlapa.o_pai_o.repositories;

import com.devlapa.o_pai_o.domain.formasPagamentos.FormasPagamentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormasPagamentosRopository extends JpaRepository<FormasPagamentos, Long> {
}
