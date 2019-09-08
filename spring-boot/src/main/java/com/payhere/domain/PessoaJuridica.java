package com.payhere.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class PessoaJuridica extends Pessoa implements Serializable {
    
    @Column(name = "cnpj_pes")
    private String cnpj;
    
    @Column(name = "ie_pes")
    private String inscricaoEstadual;
    
}
