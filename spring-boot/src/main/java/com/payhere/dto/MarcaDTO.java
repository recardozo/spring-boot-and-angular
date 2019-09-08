package com.payhere.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcaDTO implements Serializable {
    
    private Integer id;
    private String nome;
    private String descricao;
    private FornecedorDTO fornecedor;

}
