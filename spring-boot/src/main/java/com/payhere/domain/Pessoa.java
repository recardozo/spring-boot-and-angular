package com.payhere.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Pessoa implements Serializable {
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "tel")
    private String telefone;
    
    @Column(unique = true)
    private String email;
    
    @JsonIgnore
    private String senha;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_end")
    private Endereco endereco;
    
   
    public Pessoa () {
    
    }
    
    public Pessoa (String nome, String telefone, String email, String senha, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }
    
    public String getNome () {
        return nome;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public String getTelefone () {
        return telefone;
    }
    
    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }
    
    public Endereco getEndereco () {
        return endereco;
    }
    
    public void setEndereco (Endereco endereco) {
        this.endereco = endereco;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    @JsonIgnore
    public String getSenha () {
        return senha;
    }
    
    public void setSenha (String senha) {
        this.senha = senha;
    }
}
