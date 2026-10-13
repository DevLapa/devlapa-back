package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.usuarios.UsuariosRequestDTO;
import com.devlapa.o_pai_o.domain.usuarios.UsuariosResponseDTO;
import com.devlapa.o_pai_o.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuarioService usuarioService;

    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuariosResponseDTO> listarTodos() {
        return usuarioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<UsuariosResponseDTO> cadastrar(@RequestBody UsuariosRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuariosResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody UsuariosRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.atualizar(id, dto));
    }

    @PatchMapping("/{id}/tornar-admin")
    @PreAuthorize("hasRole('ADMIN')")
    public  ResponseEntity<Void> tornarAdmin(@PathVariable Long id){
        usuarioService.mudarPerfil(id, "ADMIN");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        usuarioService.inativar(id);
        return ResponseEntity.noContent().build();
    }
}