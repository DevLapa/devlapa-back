package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.fornecedores.Fornecedores;
import com.devlapa.o_pai_o.domain.fornecedores.FornecedoresRequestDTO;
import com.devlapa.o_pai_o.domain.fornecedores.FornecedoresResponseDTO;
import com.devlapa.o_pai_o.service.FornecedoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedoresController {

    @Autowired
    private FornecedoresServices fornecedoresServices;

    @PostMapping
    public ResponseEntity<Fornecedores> create(@RequestBody FornecedoresRequestDTO body){
        Fornecedores newFornecedor = this.fornecedoresServices.createFornecedores(body);
        return ResponseEntity.ok(newFornecedor);
    }

    @GetMapping
    public ResponseEntity<List<FornecedoresResponseDTO>> getFornecedores(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        List<FornecedoresResponseDTO> allFornecedores = this.fornecedoresServices.getFornecedores(page,size);
        return ResponseEntity.ok(allFornecedores);
    }
    @PatchMapping("/{id}")
    public Fornecedores updateFornecedor(@PathVariable Long id,@RequestBody Map<String,Object>fields){
        return fornecedoresServices.updateFornecedoresFields(id,fields);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFornecedor(@PathVariable Long id){
        fornecedoresServices.deleteFornecedor(id);
        return ResponseEntity.ok("Usuario deletado com sucesso");
    }


}
