package com.payhere.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    
    private Integer id;
    private String nome;
    private String rg;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;
    private EnderecoDTO endereco;
    
}
