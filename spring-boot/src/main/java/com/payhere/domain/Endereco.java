package com.payhere.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_end")
    private Integer id;
    
    @Column(name = "cep_end")
    private String cep;
    
    @Column(name = "logradouro_end")
    private String logradouro;
    
    @Column(name = "bairro_end")
    private String bairro;
    
    @Column(name = "uf_end")
    private String uf;
    
    @Column(name = "ibge_end")
    private String ibge;
    
    
    public Endereco () {
    }
    
    public Endereco (Integer id, String cep, String logradouro, String bairro, String uf, String ibge) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.uf = uf;
        this.ibge = ibge;
    }
    
    public Integer getId () {
        return id;
    }
    
    public void setId (Integer id) {
        this.id = id;
    }
    
    public String getCep () {
        return cep;
    }
    
    public void setCep (String cep) {
        this.cep = cep;
    }
    
    public String getLogradouro () {
        return logradouro;
    }
    
    public void setLogradouro (String logradouro) {
        this.logradouro = logradouro;
    }
    
    public String getBairro () {
        return bairro;
    }
    
    public void setBairro (String bairro) {
        this.bairro = bairro;
    }
    
    public String getUf () {
        return uf;
    }
    
    public void setUf (String uf) {
        this.uf = uf;
    }
    
    public String getIbge () {
        return ibge;
    }
    
    public void setIbge (String ibge) {
        this.ibge = ibge;
    }
    
    
}
