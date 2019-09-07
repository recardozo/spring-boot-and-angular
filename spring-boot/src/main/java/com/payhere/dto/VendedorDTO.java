package com.payhere.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class VendedorDTO implements Serializable {

	
	private Integer id;
	private String nome;
	private String rg;
	private String cpf;
	private BigDecimal salario;
	private BigDecimal comissao;
	private DepartamentoDTO departamento;
	
	public VendedorDTO () {
	}
	
	public VendedorDTO (Integer id, String nome, String rg, String cpf, BigDecimal salario, BigDecimal comissao, DepartamentoDTO departamento) {
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.salario = salario;
		this.comissao = comissao;
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
	
	public BigDecimal getComissao () {
		return comissao;
	}
	
	public void setComissao (BigDecimal comissao) {
		this.comissao = comissao;
	}
	
	public DepartamentoDTO getDepartamento () {
		return departamento;
	}
	
	public void setDepartamento (DepartamentoDTO departamento) {
		this.departamento = departamento;
	}
}