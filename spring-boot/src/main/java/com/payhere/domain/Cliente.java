package com.payhere.domain;

import com.payhere.domain.enums.Perfil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


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
    
    public Cliente () {
    }
    
    public Cliente (Integer id) {
//        addPerfil (Perfil.ADMIN);
    }
    
    public Cliente (String nome, String telefone, String email, String senha, Endereco endereco, String rg, String cpf, Integer id) {
        super (nome, telefone, email, senha, endereco, rg, cpf);
        this.id = id;
//        addPerfil (Perfil.CLIENTE);
    }
    
    public Integer getId () {
        return id;
    }
    
    public void setId (Integer id) {
        this.id = id;
    }
    
    
    public Set<Perfil> getPerfis () {
        return perfis.stream ().map (perfil -> Perfil.toEnum (perfil)).collect (Collectors.toSet ());
    }
    
    public void addPerfil (Perfil perfil) {
        perfis.add (perfil.getCod ());
    }
    
    
}
