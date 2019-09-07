package com.payhere.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PessoaFisica extends Pessoa {
    
    @Column(name = "rg_pes")
    private String rg;
    
    @Column(name = "cpf_pes")
    private String cpf;
    
    
    public PessoaFisica () {
    }
    
    public PessoaFisica (String rg, String cpf) {
        this.rg = rg;
        this.cpf = cpf;
    }
    public PessoaFisica (String nome, String telefone, String email, String senha, Endereco endereco, String rg, String cpf) {
        super (nome, telefone, email, senha, endereco);
        this.rg = rg;
        this.cpf = cpf;
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
}
