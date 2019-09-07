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
        
        Cliente cli1 = new Cliente ("admin", "", "admin@admin.com", encoder.encode ("admin"), null, "", "", null);
        Cliente cli2 = new Cliente ("cliente", "", "cliente@admin.com", encoder.encode ("admin"), null, "", "", null);
        cli1.addPerfil(Perfil.ADMIN);
        cli2.addPerfil (Perfil.CLIENTE);
        clienteRepository.saveAll (Arrays.asList (cli1,cli2));
        
    }
}
