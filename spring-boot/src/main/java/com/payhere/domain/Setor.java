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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "setor")
public class Setor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_setor")
    private Integer id;
    
    @Column(name = "nome_setor")
    private String nome;
    
    @Column(name = "descricao_setor")
    private String descricao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "setor")
    private List<Produto> produtos = new ArrayList<> ();
    
}
