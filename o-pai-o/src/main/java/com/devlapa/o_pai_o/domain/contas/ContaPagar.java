package com.devlapa.o_pai_o.domain.contas;

import com.devlapa.o_pai_o.domain.fornecedores.Fornecedores;
import com.devlapa.o_pai_o.domain.usuarios.Usuarios;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "contas_pagar")
@Entity(name = "ContasPagar")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ContaPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedores fornecedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_criacao_id")
    private Usuarios userCriacao;

    private String descricao;
    private BigDecimal valor;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    private String categoria;

    @Enumerated(EnumType.STRING)
    private StatusConta status = StatusConta.PENDENTE;
}
