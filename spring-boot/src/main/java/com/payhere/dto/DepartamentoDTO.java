package com.payhere.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDTO implements Serializable {
    
    private Integer id;
    private String nome;
    private String descricao;
    
}
