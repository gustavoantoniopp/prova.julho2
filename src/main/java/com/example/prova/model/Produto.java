package com.example.prova.model;

import com.example.prova.dto.ProdutoForm;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String produto;
    private String descricao;

    public Produto(){

    }
    public static Produto from (ProdutoForm produtoForm){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(produtoForm, Produto.class);

    }


    public Produto(Long id, String produto, String descricao) {
        this.id = id;
        this.produto = produto;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto1 = (Produto) o;
        return id.equals(produto1.id) && produto.equals(produto1.produto) && descricao.equals(produto1.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produto, descricao);
    }

}
