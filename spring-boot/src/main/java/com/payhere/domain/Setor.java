package com.payhere.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "setor")
public class Setor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_setor")
    private Integer id;
    
    @Column(name = "nome_setor")
    private String nome;
    
    @Column(name = "descricao_setor")
    private String descricao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "setor")
    private List<Produto> produtos = new ArrayList<> ();
    
    public Setor () {
    }
    
    public Setor (Integer id, String nome, String descricao) {
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
    
    public List<Produto> getProdutos () {
        return produtos;
    }
    
    public void setProdutos (List<Produto> produtos) {
        this.produtos = produtos;
    }
}
