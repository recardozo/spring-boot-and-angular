package com.payhere.services;

import com.payhere.domain.Cliente;
import com.payhere.domain.enums.Perfil;
import com.payhere.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    
    @Autowired
    ClienteRepository clienteRepository;
    
    @Autowired
    BCryptPasswordEncoder encoder;
    
    public void instantiateTestDatabase () throws ParseException {
        
        Cliente cli1 = new Cliente ();
        cli1.setNome ("admin");
        cli1.setEmail ("admin@admin.com");
        cli1.setSenha (encoder.encode ("admin"));
        
        Cliente cli2 = new Cliente ();
        cli2.setNome ("cliente");
        cli2.setEmail ("cliente@admin.com");
        cli2.setSenha (encoder.encode ("admin"));
        
        cli1.addPerfil(Perfil.ADMIN);
        cli2.addPerfil (Perfil.CLIENTE);
        clienteRepository.saveAll (Arrays.asList (cli1,cli2));
        
    }
}
