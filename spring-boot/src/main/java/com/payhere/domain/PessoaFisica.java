package com.payhere.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class PessoaFisica extends Pessoa {
    
    @Column(name = "rg_pes")
    private String rg;
    
    @Column(name = "cpf_pes")
    private String cpf;
    
}
