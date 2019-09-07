package com.payhere.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    
    public Departamento () {
    }
    
    public Departamento (Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public Integer getId () {
        return id;
    }
    
    public void setId (Integer id) {
        this.id = id;
    }
    
    public String getNome () {
        return nome;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public String getDescricao () {
        return descricao;
    }
    
    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }
    
    public List<Funcionario> getFuncionarios () {
        return funcionarios;
    }
    
    public void setFuncionarios (List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
