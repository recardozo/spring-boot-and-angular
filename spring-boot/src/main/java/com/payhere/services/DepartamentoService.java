package com.payhere.services;

import com.payhere.domain.Departamento;
import com.payhere.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    
    @Autowired
    DepartamentoRepository repository;
    
    public List<Departamento> getAll () {
        return repository.findAll ();
    }
    
    public Departamento getById (Integer id) {
        Optional<Departamento> departamento = repository.findById (id);
        // refatorar criar exceção customizada
        return departamento.orElseThrow (() -> new RuntimeException ("Object not found" + Departamento.class.getName ()));
    }
    
    public Departamento save (Departamento departamento) {
        departamento.setId (null);
        return repository.save (departamento);
    }
    
    public Departamento update (Departamento departamento) {
        Departamento newDepartamento = getById (departamento.getId ());
        return repository.save (departamento);
    }
    
    public void deleteById (Integer id) {
        try {
            repository.deleteById (id);
        } catch (RuntimeException e) {
            e.getMessage ();
        }
        
    }
    
    
}
