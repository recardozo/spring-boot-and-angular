package com.payhere.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends PessoaJuridica implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forn")
    private Integer id;
    
    @Column(name = "nome_forn")
    private String nome;
    
    @JsonIgnore
    @OneToMany(mappedBy = "fornecedor")
    private List<Marca> marcas = new ArrayList<> ();
    
    public Fornecedor () {
    
    }
    
    public Fornecedor (String cnpj, String inscricaoEstadual) {
        super (cnpj, inscricaoEstadual);
    }
    
    public Fornecedor (String cnpj, String inscricaoEstadual, Integer id, String nome) {
        super (cnpj, inscricaoEstadual);
        this.id = id;
        this.nome = nome;
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
    
    public List<Marca> getMarcas () {
        return marcas;
    }
    
    public void setMarcas (List<Marca> marcas) {
        this.marcas = marcas;
    }
}
