package com.payhere.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Pessoa implements Serializable {
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "tel")
    private String telefone;
    
    @Column(unique = true)
    private String email;
    
    @JsonIgnore
    private String senha;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_end")
    private Endereco endereco;

}
