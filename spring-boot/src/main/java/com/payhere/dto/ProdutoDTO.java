package com.payhere.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.payhere.domain.enums.Colecao;
import com.payhere.utils.MoneySerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO implements Serializable {
    
    private Integer id;
    private String nome;
    private String descricao;
    @JsonDeserialize(using = MoneySerializer.class, as = BigDecimal.class)
    private BigDecimal preco;
    private MarcaDTO marca;
    private SetorDTO setor;
    private Colecao colecao;
    
}
