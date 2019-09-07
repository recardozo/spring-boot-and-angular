package com.payhere.services;

import com.payhere.domain.Marca;
import com.payhere.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    MarcaRepository repository;

    public List<Marca> getAll() {
        return repository.findAll();
    }

    public Marca getById(Integer id) {
        Optional<Marca> marca = repository.findById(id);
        // refatorar criar exceção customizada
        return marca.orElseThrow(() -> new RuntimeException("Object not found" + Marca.class.getName()));
    }

    public Marca save(Marca marca) {
        marca.setId(null);
        return repository.save(marca);
    }

    public Marca update(Marca marca) {
        Marca newMarca = getById(marca.getId());
        return repository.save(marca);
    }

    public void deleteById(Integer id){
        try {
            repository.deleteById(id);
        }catch (RuntimeException e){
            e.getMessage();
        }

    }


}
