package com.payhere.domain;

import com.payhere.domain.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pagamento")
	private Long id;

	private String descricao;

	@Enumerated(EnumType.STRING)
	private TipoPagamento tipo;
	
}