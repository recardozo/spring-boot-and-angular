package com.payhere.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vendedor")
public class Vendedor extends Funcionario implements Serializable {
    
    
    @Column(name = "vendedor_comissao")
    private BigDecimal comissao;
    
//    @OneToMany(mappedBy = "vendedor")
//    private List<Venda> vendas = new ArrayList<>();
    
}
