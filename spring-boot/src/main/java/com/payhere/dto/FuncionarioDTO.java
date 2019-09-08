package com.payhere.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.payhere.utils.MoneySerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO implements Serializable {
    
    private Integer id;
    private String nome;
    private String rg;
    private String cpf;
    @JsonDeserialize(using = MoneySerializer.class, as = BigDecimal.class)
    private BigDecimal salario;
    private DepartamentoDTO departamento;
    
}
