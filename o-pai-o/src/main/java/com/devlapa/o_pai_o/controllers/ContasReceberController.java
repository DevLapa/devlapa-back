package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.contas.ContaPagarResponseDTO;
import com.devlapa.o_pai_o.domain.contas.ContasReceberResponseDTO;
import com.devlapa.o_pai_o.domain.contas.DadosCadastroContaPagar;
import com.devlapa.o_pai_o.domain.contas.DadosCadastroContaReceber;
import com.devlapa.o_pai_o.service.ContasReceberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/contas-receber")
public class ContasReceberController {

    @Autowired
    private ContasReceberService service;


    @GetMapping
    public List<ContasReceberResponseDTO> listarTodas() {
        return service.listarTodas().stream().map(ContasReceberResponseDTO::new).toList();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE')")
    public ResponseEntity<ContasReceberResponseDTO> cadastrar(@RequestBody @Valid DadosCadastroContaReceber dados) {
        return ResponseEntity.ok(new ContasReceberResponseDTO(service.salvar(dados)));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE')")
    public ResponseEntity<ContasReceberResponseDTO> editar(@PathVariable Long id, @RequestBody @Valid DadosCadastroContaReceber dados) {
        return ResponseEntity.ok(new ContasReceberResponseDTO(service.atualizar(id, dados)));
    }

    @PatchMapping("/{id}/receber")
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE')")
    public ResponseEntity<ContaPagarResponseDTO> receber(@PathVariable Long id){
        service.marcarComoRecebida(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE')")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
