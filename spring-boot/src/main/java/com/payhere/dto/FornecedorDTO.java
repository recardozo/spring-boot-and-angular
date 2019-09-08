package com.payhere.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorDTO implements Serializable {
	
	private Integer id;
	private String nome;
//	private EnderecoDTO endereco;
	private String telefone;
	private String cnpj;
	private String inscricaoEstadual;
	
}