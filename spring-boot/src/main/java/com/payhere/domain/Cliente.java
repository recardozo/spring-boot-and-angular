package com.payhere.domain;

import com.payhere.domain.enums.Perfil;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends PessoaFisica implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cli")
    private Integer id;

//    @OneToMany(mappedBy = "cliente")
//    private List<Venda> vendas = new ArrayList<>();
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    private Set<Integer> perfis = new HashSet<> ();
    
    public Set<Perfil> getPerfis () {
        return perfis.stream ().map (perfil -> Perfil.toEnum (perfil)).collect (Collectors.toSet ());
    }
    
    public void addPerfil (Perfil perfil) {
        perfis.add (perfil.getCod ());
    }
    
    
}
