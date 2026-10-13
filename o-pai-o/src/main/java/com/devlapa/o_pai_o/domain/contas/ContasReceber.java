package com.devlapa.o_pai_o.domain.contas;

import com.devlapa.o_pai_o.domain.comandas.Comanda;
import com.devlapa.o_pai_o.domain.usuarios.Usuarios;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "contas_receber")
@Entity(name = "ContasReceber")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ContasReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String descricao;
    private BigDecimal valor;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_recebimento")
    private LocalDate dataRecebimento;

    @Column(name = "data_criacao")
    private LocalDateTime datacriacao;

    @Enumerated(EnumType.STRING)
    private StatusConta status = StatusConta.PENDENTE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_criacao_id")
    private Usuarios userCriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comanda_id")
    private Comanda comanda;
}
