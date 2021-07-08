package com.example.prova.controller;

import com.example.prova.dto.EmpresaDto;
import com.example.prova.dto.EmpresaForm;
import com.example.prova.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @GetMapping
    public ResponseEntity<List<EmpresaDto>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping
    public ResponseEntity<EmpresaDto> save(@RequestBody @Validated EmpresaForm empresaForm){
        return ResponseEntity.ok(service.save(empresaForm));
    }
    }

