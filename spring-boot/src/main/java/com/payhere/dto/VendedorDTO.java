package com.payhere.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorDTO implements Serializable {
	
	private Integer id;
	private String nome;
	private String rg;
	private String cpf;
	private BigDecimal salario;
	private BigDecimal comissao;
	private DepartamentoDTO departamento;
	
}