package com.payhere.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "vendedor")
public class Vendedor extends Funcionario implements Serializable {
    
    
    @Column(name = "vendedor_comissao")
    private BigDecimal comissao;
    
//    @OneToMany(mappedBy = "vendedor")
//    private List<Venda> vendas = new ArrayList<>();
    
    public Vendedor (){
    
    }
    public Vendedor (BigDecimal comissao) {
        this.comissao = comissao;
    }
    
    public Vendedor (String rg, String cpf, BigDecimal comissao) {
        super (rg, cpf);
        this.comissao = comissao;
    }
    
    public Vendedor (String rg, String cpf, Integer id, BigDecimal salario, Departamento departamento, BigDecimal comissao) {
        super (rg, cpf, id, salario, departamento);
        this.comissao = comissao;
    }
    
    public BigDecimal getComissao () {
        return comissao;
    }
    
    public void setComissao (BigDecimal comissao) {
        this.comissao = comissao;
    }
}
