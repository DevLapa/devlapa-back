package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.categorias.CategoriaRequestDTO;
import com.devlapa.o_pai_o.domain.categorias.CategoriaResponseDTO;
import com.devlapa.o_pai_o.domain.categorias.Categorias;
import com.devlapa.o_pai_o.service.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    @Autowired
    private CategoriaServices categoriaService;

    @PostMapping
    public ResponseEntity<Categorias> create(@RequestBody CategoriaRequestDTO body){
        Categorias newCategoria = this.categoriaService.createCategoria(body);
        return ResponseEntity.ok(newCategoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> getCategorias(@RequestParam (defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        List<CategoriaResponseDTO> allCategorias = this.categoriaService.getCategorias(page, size);
        return ResponseEntity.ok(allCategorias);
    }

    @PatchMapping("/{id}")
    public Categorias updateCategorias(@PathVariable long id, @RequestBody Map<String, Object>fields){
        return categoriaService.updateCategoriaFinds(id,fields);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Long id){
        categoriaService.deleteCategoria(id);
        return ResponseEntity.ok("Categoria deletada com sucesso");
    }

}
