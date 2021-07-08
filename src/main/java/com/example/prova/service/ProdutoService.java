package com.example.prova.service;

import com.example.prova.dto.ProdutoDto;
import com.example.prova.dto.ProdutoForm;
import com.example.prova.model.Produto;
import com.example.prova.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private ProdutoService(ProdutoRepository produtoRepository){ this.produtoRepository = produtoRepository;}

    public List<ProdutoDto> findAll(){
        List<Produto> list = produtoRepository.findAll();
        return list.stream().map(ProdutoDto::from).collect(Collectors.toList());
    }
    public ProdutoDto save(ProdutoForm produtoForm){
        Produto produto = Produto.from(produtoForm);
        return  ProdutoDto.from(produtoRepository.save(produto));
    }
}
