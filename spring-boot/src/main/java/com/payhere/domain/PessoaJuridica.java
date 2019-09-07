package com.payhere.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class PessoaJuridica extends Pessoa implements Serializable {
    
    @Column(name = "cnpj_pes")
    private String cnpj;
    
    @Column(name = "ie_pes")
    private String inscricaoEstadual;
    
    public PessoaJuridica () {
    }
    
    public PessoaJuridica (String cnpj, String inscricaoEstadual) {
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }
    
    public String getCnpj () {
        return cnpj;
    }
    
    public void setCnpj (String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getInscricaoEstadual () {
        return inscricaoEstadual;
    }
    
    public void setInscricaoEstadual (String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}
