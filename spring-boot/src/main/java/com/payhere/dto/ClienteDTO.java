package com.payhere.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

public class ClienteDTO implements Serializable {
    
    private Integer id;
    private String nome;
    private String rg;
    private String cpf;
    private String telefone;
    private String email;
    
    
    private String senha;
    
    private EnderecoDTO endereco;
    
    
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
    
    public String getRg () {
        return rg;
    }
    
    public void setRg (String rg) {
        this.rg = rg;
    }
    
    public String getCpf () {
        return cpf;
    }
    
    public void setCpf (String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone () {
        return telefone;
    }
    
    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
    public String getSenha () {
        return senha;
    }
    
    public void setSenha (String senha) {
        this.senha = senha;
    }
    
    public EnderecoDTO getEndereco () {
        return endereco;
    }
    
    public void setEndereco (EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
