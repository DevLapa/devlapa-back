package com.devlapa.o_pai_o.domain.movimentacao;

import com.devlapa.o_pai_o.domain.estoque.Estoque;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estoque_id", nullable = false)
    private Estoque estoque;

    @Column(nullable = false)
    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimentacao tipo;

    private String motivo;

    @Column(name = "usuario_responsavel")
    private String usuarioResponsavel;

    private LocalDateTime dataHora;

    @PrePersist
    public void prePersist(){
        this.dataHora = LocalDateTime.now();
    }
}
