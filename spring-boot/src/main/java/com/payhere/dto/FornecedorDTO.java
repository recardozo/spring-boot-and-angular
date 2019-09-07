package com.payhere.dto;

import java.io.Serializable;

public class FornecedorDTO implements Serializable {

	
	private Integer id;
	private String nome;
//	private EnderecoDTO endereco;
	private String telefone;
	private String cnpj;
	private String inscricaoEstadual;
	
	public FornecedorDTO () {
	}
	
	public FornecedorDTO (Integer id, String nome, String telefone, String cnpj, String inscricaoEstadual) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
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
	
	public String getTelefone () {
		return telefone;
	}
	
	public void setTelefone (String telefone) {
		this.telefone = telefone;
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