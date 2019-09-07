package com.payhere.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "funcionario")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Funcionario extends PessoaFisica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_func")
    private Integer id;
    
    @Column(name = "salario_func")
    private BigDecimal salario;
    
    @ManyToOne(cascade =  CascadeType.DETACH )
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
    
    
    public Funcionario () {
    }
    
    public Funcionario (String rg, String cpf) {
        super (rg, cpf);
    }
    
    public Funcionario (String rg, String cpf, Integer id, BigDecimal salario, Departamento departamento) {
        super (rg, cpf);
        this.id = id;
        this.salario = salario;
        this.departamento = departamento;
    }
    
    public Integer getId () {
        return id;
    }
    
    public void setId (Integer id) {
        this.id = id;
    }
    
    public BigDecimal getSalario () {
        return salario;
    }
    
    public void setSalario (BigDecimal salario) {
        this.salario = salario;
    }
    
    public Departamento getDepartamento () {
        return departamento;
    }
    
    public void setDepartamento (Departamento departamento) {
        this.departamento = departamento;
    }
}
