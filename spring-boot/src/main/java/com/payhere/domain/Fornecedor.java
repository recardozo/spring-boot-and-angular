package com.payhere.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fornecedor")
public class Fornecedor extends PessoaJuridica implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forn")
    private Integer id;
    
    @Column(name = "nome_forn")
    private String nome;
    
    @JsonIgnore
    @OneToMany(mappedBy = "fornecedor")
    private List<Marca> marcas = new ArrayList<> ();
    
}
