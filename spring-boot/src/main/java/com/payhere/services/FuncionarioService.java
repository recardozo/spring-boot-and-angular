package com.payhere.services;

import com.payhere.domain.Funcionario;
import com.payhere.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    public List<Funcionario> getAll() {
        return repository.findAll();
    }

    public Funcionario getById(Integer id) {
        Optional<Funcionario> funcionario = repository.findById(id);
        // refatorar criar exceção customizada
        return funcionario.orElseThrow(() -> new RuntimeException("Object not found" + Funcionario.class.getName()));
    }

    public Funcionario save(Funcionario funcionario) {
        funcionario.setId(null);
        return repository.save(funcionario);
    }

    public Funcionario update(Funcionario funcionario) {
        Funcionario newFuncionario = getById(funcionario.getId());
//        funcionario.getDepartamento().setId(newFuncionario.getId());
        return repository.save(funcionario);
    }

    public void deleteById(Integer id){
        try {
            repository.deleteById(id);
        }catch (RuntimeException e){
            e.getMessage();
        }

    }


}
