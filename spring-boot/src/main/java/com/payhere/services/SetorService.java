package com.payhere.services;


import com.payhere.domain.Setor;
import com.payhere.repositories.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {
    
    @Autowired
    SetorRepository repository;
    
    public List<Setor> getAll() {
        return repository.findAll();
    }
    
    public Setor getById(Integer id) {
        Optional<Setor> setor = repository.findById(id);
        // refatorar criar exceção customizada
        return setor.orElseThrow(() -> new RuntimeException("Object not found" + Setor.class.getName()));
    }
    
    public Setor save(Setor setor) {
        setor.setId(null);
        return repository.save(setor);
    }
    
    public Setor update(Setor setor) {
        Setor newSetor= getById(setor.getId());
        return repository.save(setor);
    }
    
    public void deleteById(Integer id){
        try {
            repository.deleteById(id);
        }catch (RuntimeException e){
            e.getMessage();
        }
        
    }
}
