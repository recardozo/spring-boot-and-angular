package com.payhere.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Integer id;
    
    @Column(name = "nome_departamento")
    private String nome;
    
    @Column(name = "descricao_departamento")
    private String descricao;
    
    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionarios;
    
}
