package com.payhere.services;

import com.payhere.domain.Fornecedor;
import com.payhere.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository repository;

    public List<Fornecedor> getAll() {
        return repository.findAll();
    }

    public Fornecedor getById(Integer id) {
        Optional<Fornecedor> fornecedor = repository.findById(id);
        // refatorar criar exceção customizada
        return fornecedor.orElseThrow(() -> new RuntimeException("Object not found" + Fornecedor.class.getName()));
    }

    public Fornecedor save(Fornecedor fornecedor) {
        fornecedor.setId(null);
        return repository.save(fornecedor);
    }

    public Fornecedor update(Fornecedor fornecedor) {
        Fornecedor newFornecedor = getById(fornecedor.getId());
        return repository.save(fornecedor);
    }

    public void deleteById(Integer id){
        try {
            repository.deleteById(id);
        }catch (RuntimeException e){
            e.getMessage();
        }

    }


}
