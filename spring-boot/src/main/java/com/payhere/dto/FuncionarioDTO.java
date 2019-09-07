package com.payhere.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.payhere.utils.MoneySerializer;

import java.io.Serializable;
import java.math.BigDecimal;

public class FuncionarioDTO implements Serializable {
    
    private Integer id;
    private String nome;
    private String rg;
    private String cpf;
    @JsonDeserialize(using = MoneySerializer.class, as = BigDecimal.class)
    private BigDecimal salario;
    private DepartamentoDTO departamento;
    
    public FuncionarioDTO () {
    }
    
    public FuncionarioDTO (Integer id, String nome, String rg, String cpf, BigDecimal salario, DepartamentoDTO departamento) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.salario = salario;
        this.departamento = departamento;
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
    
    public BigDecimal getSalario () {
        return salario;
    }
    
    public void setSalario (BigDecimal salario) {
        this.salario = salario;
    }
    
    public DepartamentoDTO getDepartamento () {
        return departamento;
    }
    
    public void setDepartamento (DepartamentoDTO departamento) {
        this.departamento = departamento;
    }
}
