package com.example.prova.service;

import com.example.prova.dto.EmpresaDto;
import com.example.prova.dto.EmpresaForm;
import com.example.prova.model.Empresa;
import com.example.prova.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    private EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public List<EmpresaDto> findAll(){
        List<Empresa> list = empresaRepository.findAll();
        return list.stream().map(EmpresaDto::from).collect(Collectors.toList());
    }

    public EmpresaDto save(EmpresaForm empresaForm){
        Empresa empresa = Empresa.from(empresaForm);
        return EmpresaDto.from(empresaRepository.save(empresa));
    }
}
