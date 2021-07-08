package com.example.prova.controller;

import com.example.prova.dto.ProdutoDto;
import com.example.prova.dto.ProdutoForm;
import com.example.prova.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping
    public ResponseEntity<ProdutoDto> save(@RequestBody @Validated ProdutoForm produtoForm){
        return ResponseEntity.ok(service.save(produtoForm));
    }
}
