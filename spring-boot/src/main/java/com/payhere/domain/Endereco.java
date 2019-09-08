package com.payhere.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_end")
    private Integer id;
    
    @Column(name = "cep_end")
    private String cep;
    
    @Column(name = "logradouro_end")
    private String logradouro;
    
    @Column(name = "bairro_end")
    private String bairro;
    
    @Column(name = "uf_end")
    private String uf;
    
    @Column(name = "ibge_end")
    private String ibge;
    
}
