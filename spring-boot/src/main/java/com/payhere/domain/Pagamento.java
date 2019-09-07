package com.payhere.domain;

import com.payhere.domain.enums.TipoPagamento;

import javax.persistence.*;
import java.io.Serializable;

public class Pagamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pagamento")
	private Long id;

	private String descricao;

	@Enumerated(EnumType.STRING)
	private TipoPagamento tipo;
	
	public Pagamento (Long id, String descricao, TipoPagamento tipo) {
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
	}
	
	public Long getId () {
		return id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public void setDescricao (String descricao) {
		this.descricao = descricao;
	}
	
	public TipoPagamento getTipo () {
		return tipo;
	}
	
	public void setTipo (TipoPagamento tipo) {
		this.tipo = tipo;
	}
}