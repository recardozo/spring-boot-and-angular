package com.payhere.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.payhere.domain.enums.Colecao;
import com.payhere.utils.MoneySerializer;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProdutoDTO implements Serializable {
    
    private Integer id;
    private String nome;
    private String descricao;
    @JsonDeserialize(using = MoneySerializer.class, as = BigDecimal.class)
    private BigDecimal preco;
    private MarcaDTO marca;
    private SetorDTO setor;
    private Colecao colecao;
    
    public ProdutoDTO () {
    }
    
    public ProdutoDTO (Integer id, String nome, String descricao, BigDecimal preco, MarcaDTO marca, SetorDTO setorDTO, Colecao colecao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.marca = marca;
        this.setor = setorDTO;
        this.colecao = colecao;
    }
    
    public Integer getId () {
        return id;
    }
    
    public void setId (Integer id) {
        this.id = id;
    }
    
    public String getNome () {
        return nome;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public String getDescricao () {
        return descricao;
    }
    
    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }
    
    public BigDecimal getPreco () {
        return preco;
    }
    
    public void setPreco (BigDecimal preco) {
        this.preco = preco;
    }
    
    public MarcaDTO getMarca () {
        return marca;
    }
    
    public void setMarca (MarcaDTO marca) {
        this.marca = marca;
    }
    
    public SetorDTO getSetor () {
        return setor;
    }
    
    public void setSetor (SetorDTO setor) {
        this.setor = setor;
    }
    
    public Colecao getColecao () {
        return colecao;
    }
    
    public void setColecao (Colecao colecao) {
        this.colecao = colecao;
    }
}
