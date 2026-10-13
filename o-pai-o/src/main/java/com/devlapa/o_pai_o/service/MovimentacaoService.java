package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.estoque.StatusEstoque;
import com.devlapa.o_pai_o.domain.movimentacao.*;
import com.devlapa.o_pai_o.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<MovimentacaoResponseDTO> listarTodas() {
        return repository.findAll().stream().map(MovimentacaoResponseDTO::new).toList();
    }

    public MovimentacaoResponseDTO buscarPorId(Long id) {
        return new MovimentacaoResponseDTO(buscarEntidade(id));
    }

    @Transactional
    public void registrar(MovimentacaoRequestDTO dto) {
        var estoque = estoqueRepository.findById(dto.estoqueId())
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));


        if (dto.tipo() == TipoMovimentacao.SAIDA && estoque.getQuantidade() < dto.quantidade()) {
            throw new RuntimeException("Saldo insuficiente! Estoque atual: " + estoque.getQuantidade());
        }


        if (dto.tipo() == TipoMovimentacao.ENTRADA) {
            estoque.setQuantidade(estoque.getQuantidade() + dto.quantidade());
        } else {
            estoque.setQuantidade(estoque.getQuantidade() - dto.quantidade());
        }


        if (estoque.getQuantidade() <= estoque.getMinimo()) {
            estoque.setStatus(StatusEstoque.CRITICO);
        } else {
            estoque.setStatus(StatusEstoque.NORMAL);
        }


        String usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getName();

        var mov = Movimentacao.builder()
                .estoque(estoque)
                .quantidade(dto.quantidade())
                .tipo(dto.tipo())
                .motivo(dto.motivo())
                .usuarioResponsavel(usuarioLogado)
                .dataHora(LocalDateTime.now())
                .build();

        estoqueRepository.save(estoque);
        repository.save(mov);
    }

    @Transactional
    public void deletar(Long id) {
        var mov = buscarEntidade(id);
        var estoque = mov.getEstoque();


        if (mov.getTipo() == TipoMovimentacao.ENTRADA) {
            estoque.setQuantidade(estoque.getQuantidade() - mov.getQuantidade());
        } else {
            estoque.setQuantidade(estoque.getQuantidade() + mov.getQuantidade());
        }

        estoqueRepository.save(estoque);
        repository.delete(mov);
    }

    @Transactional
    public void atualizar(Long id, MovimentacaoRequestDTO dto) {
        deletar(id);
        registrar(dto);
    }

    private Movimentacao buscarEntidade(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimentação não encontrada"));
    }
}