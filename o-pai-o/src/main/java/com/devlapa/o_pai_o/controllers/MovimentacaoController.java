package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.movimentacao.MovimentacaoRequestDTO;
import com.devlapa.o_pai_o.domain.movimentacao.MovimentacaoResponseDTO;
import com.devlapa.o_pai_o.service.MovimentacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService service;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE')")
    public ResponseEntity<String> registrar(@RequestBody @Valid MovimentacaoRequestDTO dto) {
        service.registrar(dto);
        return ResponseEntity.ok("Movimentação realizada com sucesso. Estoque e status atualizados.");
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE', 'USUARIO')")
    public ResponseEntity<List<MovimentacaoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE', 'USUARIO')")
    public ResponseEntity<MovimentacaoResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE')")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody @Valid MovimentacaoRequestDTO dto) {
        service.atualizar(id, dto);
        return ResponseEntity.ok("Movimentação corrigida e saldo estornado/recalculado com sucesso.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}