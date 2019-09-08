package com.payhere.domain;

import com.payhere.domain.enums.Colecao;
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
@Table(name = "produto")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;
    
    @Column(name = "nome_produto")
    private String nome;
    
    @Column(name = "descricao_produto")
    private String descricao;
    
    @Column(name = "preco_produto")
    private BigDecimal preco;
    
    @Enumerated(EnumType.STRING)
    private Colecao colecao;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marca_produto")
    private Marca marca;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "setor_produto")
    private Setor setor;
    
}
