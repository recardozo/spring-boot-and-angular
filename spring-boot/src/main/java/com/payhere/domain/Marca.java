package com.payhere.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "marca")
public class Marca implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Integer id;
    
    @Column(name = "nome_marca")
    private String nome;
    
    @Column(name = "descricao_marca")
    private String descricao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "marca")
    private List<Produto> produtos = new ArrayList<> ();
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forn_marca")
    private Fornecedor fornecedor;
    
    public Marca () {
    }
    
    public Marca (Integer id, String nome, String descricao, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
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
    
    public Fornecedor getFornecedor () {
        return fornecedor;
    }
    
    public void setFornecedor (Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
