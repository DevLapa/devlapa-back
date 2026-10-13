package com.devlapa.o_pai_o.domain.formasPagamentos;

import com.devlapa.o_pai_o.domain.vendas.Vendas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "formas_de_pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormasPagamentos {
    @Id
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String tipo;

    @Column(name = "permit_parcelamento")
    private boolean permitirParcelamento;

    private boolean ativo;

    private LocalDateTime data_criacao;

    private LocalDateTime data_modificacao;


    public void PrePersist(){
        this.ativo = true;
        this.permitirParcelamento = false;
        this.data_criacao = LocalDateTime.now();
        this.data_modificacao = LocalDateTime.now();
    }
    @JsonIgnore
    @OneToMany(mappedBy = "formasPagamentos",cascade = CascadeType.ALL)
    private List<Vendas> vendasList;
}
