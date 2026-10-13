package com.devlapa.o_pai_o.repositories;

import com.devlapa.o_pai_o.domain.produtos.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}
