package com.payhere.domain;

import com.payhere.domain.enums.Colecao;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;
    
    @Column(name = "nome_produto")
    private String nome;
    
    @Column(name = "descricao_produto")
    private String descricao;
    
    @Column(name = "preco_produto")
    private BigDecimal preco;
    
    @Enumerated(EnumType.STRING)
    private Colecao colecao;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marca_produto")
    private Marca marca;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "setor_produto")
    private Setor setor;
    
    public Produto () {
    }
    
    public Produto (Integer id, String nome, String descricao, BigDecimal preco, Colecao colecao, Marca marca, Setor setor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.colecao = colecao;
        this.marca = marca;
        this.setor = setor;
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
    
    public Colecao getColecao () {
        return colecao;
    }
    
    public void setColecao (Colecao colecao) {
        this.colecao = colecao;
    }
    
    public Marca getMarca () {
        return marca;
    }
    
    public void setMarca (Marca marca) {
        this.marca = marca;
    }
    
    public Setor getSetor () {
        return setor;
    }
    
    public void setSetor (Setor setor) {
        this.setor = setor;
    }
}
