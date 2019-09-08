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
@Table(name = "marca")
public class Marca implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Integer id;
    
    @Column(name = "nome_marca")
    private String nome;
    
    @Column(name = "descricao_marca")
    private String descricao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "marca")
    private List<Produto> produtos = new ArrayList<> ();
    
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "forn_marca")
    private Fornecedor fornecedor;
    
}
