package com.payhere.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
    
}
