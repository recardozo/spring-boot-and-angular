package com.payhere.services;

import com.payhere.domain.Cliente;
import com.payhere.domain.enums.Perfil;
import com.payhere.repositories.ClienteRepository;
import com.payhere.security.UserDetailsImpl;
import com.payhere.services.exceptions.AuthorizationException;
import com.payhere.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository repository;
    
    @Autowired
    BCryptPasswordEncoder encoder;
    
    public List<Cliente> getAll () {
        return repository.findAll ();
    }
    
    public Cliente getById (Integer id) {
        UserDetailsImpl user = UserService.authenticated ();
        System.out.println (user.getUsername () + user.getId ());
        if (user == null || !user.hasRole (Perfil.ADMIN) && !id.equals (user.getId ())) {
    
            throw new AuthorizationException ("Acesso negado");
        }
        
        Optional<Cliente> cliente = repository.findById (id);
        // refatorar criar exceção customizada
        return cliente.orElseThrow (() -> new ObjectNotFoundException (
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName ()));
    }
    
    public Cliente save (Cliente cliente) {
        cliente.setId (null);
        return repository.save (cliente);
    }
    
    public Cliente update (Cliente cliente) {
        Cliente newCliente = getById (cliente.getId ());
        return repository.save (cliente);
    }
    
    public void deleteById (Integer id) {
        try {
            repository.deleteById (id);
        } catch (RuntimeException e) {
            e.getMessage ();
        }
        
    }
    
    
}
