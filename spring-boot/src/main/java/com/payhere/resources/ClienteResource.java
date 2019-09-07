package com.payhere.resources;

import com.payhere.domain.Cliente;
import com.payhere.dto.ClienteDTO;
import com.payhere.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteResource {
    
    
    @Autowired
    ClienteService service;
    
    ModelMapper mapper = new ModelMapper ();
    
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getCliente (@PathVariable Integer id) {
        Cliente cliente = service.getById (id);
        ClienteDTO clienteDTO = mapper.map (cliente, ClienteDTO.class);
        return ResponseEntity.ok ().body (clienteDTO);
    }
    
    @PostMapping
    public ResponseEntity<Cliente> createCliente (@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = mapper.map (clienteDTO, Cliente.class);
        cliente = service.save (cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}").buildAndExpand (cliente.getId ()).toUri ();
        return ResponseEntity.created (uri).build ();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente (@RequestBody ClienteDTO clienteDTO, @PathVariable Integer id) {
        Cliente cliente = mapper.map (clienteDTO, Cliente.class);
        cliente.setId (id);
        cliente = service.update (cliente);
        return ResponseEntity.noContent ().build ();
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> getAllDClientes () {
        List<Cliente> clientes = service.getAll ();
        List<ClienteDTO> clientesDTO = new ArrayList<> ();
        
        for (Cliente cliente : clientes) {
            ClienteDTO clienteDTO = mapper.map (cliente, ClienteDTO.class);
            clientesDTO.add (clienteDTO);
        }
        return ResponseEntity.ok ().body (clientesDTO);
        
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente (@PathVariable Integer id) {
        service.deleteById (id);
        return ResponseEntity.noContent ().build ();
    }
    
    
}
