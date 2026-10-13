package com.devlapa.o_pai_o.domain.comandas;

import com.devlapa.o_pai_o.domain.produtos.Produtos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_comanda")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ItemComanda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "comanda_id")
    @JsonIgnore
    private Comanda comanda;

    @ManyToOne @JoinColumn(name = "produto_id")
    private Produtos produtos;

    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;
}
