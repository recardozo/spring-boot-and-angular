package com.payhere.services;

import com.payhere.domain.Produto;
import com.payhere.domain.Setor;
import com.payhere.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    
    @Autowired
    ProdutoRepository repository;
    
    public List<Produto> getAll () {
        return repository.findAll ();
    }
    
    public Produto getById (Integer id) {
        Optional<Produto> produto = repository.findById (id);
        return produto.orElseThrow (() -> new RuntimeException ("Object not found" + Setor.class.getName ()));
    }
    
    public Produto save (Produto produto) {
        produto.setId (null);
        return repository.save (produto);
    }
    
    public Produto update (Produto produto) {
        Produto newProduto = getById (produto.getId ());
        return repository.save (produto);
    }
    
    public void deleteById (Integer id) {
        try {
            repository.deleteById (id);
        } catch (RuntimeException e) {
            e.getMessage ();
        }
        
    }
    
}
