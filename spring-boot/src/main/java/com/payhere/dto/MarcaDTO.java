package com.payhere.dto;

import java.io.Serializable;

public class MarcaDTO implements Serializable {
    
    private Integer id;
    private String nome;
    private String descricao;
    
    public MarcaDTO () {
    }
    
    public MarcaDTO (Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        
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
    
    
}
