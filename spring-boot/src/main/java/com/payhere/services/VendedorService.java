package com.payhere.services;

import com.payhere.domain.Vendedor;
import com.payhere.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {
    
    @Autowired
    VendedorRepository repository;
    
    public List<Vendedor> getAll () {
        return repository.findAll ();
    }
    
    public Vendedor getById (Integer id) {
        Optional<Vendedor> vendedor = repository.findById (id);
        // refatorar criar exceção customizada
        return vendedor.orElseThrow (() -> new RuntimeException ("Object not found" + Vendedor.class.getName ()));
    }
    
    public Vendedor save (Vendedor vendedor) {
        vendedor.setId (null);
        return repository.save (vendedor);
    }
    
    public Vendedor update (Vendedor vendedor) {
        Vendedor newVendedor = getById (vendedor.getId ());
        vendedor.getDepartamento().setId(newVendedor.getId());
        return repository.save (vendedor);
    }
    
    public void deleteById (Integer id) {
        try {
            repository.deleteById (id);
        } catch (RuntimeException e) {
            e.getMessage ();
        }
        
    }
    
    
}
