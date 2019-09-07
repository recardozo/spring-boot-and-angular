package com.payhere.resources;

import com.payhere.domain.Funcionario;
import com.payhere.dto.FuncionarioDTO;
import com.payhere.services.FuncionarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioResource {
    
    
    @Autowired
    FuncionarioService service;
    
    ModelMapper mapper = new ModelMapper ();
    
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> getFuncionario (@PathVariable Integer id) {
        Funcionario funcionario = service.getById (id);
        FuncionarioDTO funcionarioDTO = mapper.map (funcionario, FuncionarioDTO.class);
        return ResponseEntity.ok ().body (funcionarioDTO);
    }
    
    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario (@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = mapper.map (funcionarioDTO, Funcionario.class);
        funcionario = service.save (funcionario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}").buildAndExpand (funcionario.getId ()).toUri ();
        return ResponseEntity.created (uri).build ();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> updateaFuncionario (@RequestBody FuncionarioDTO funcionarioDTO, @PathVariable Integer id) {
        Funcionario funcionario = mapper.map (funcionarioDTO, Funcionario.class);
        funcionario.setId (id);
        funcionario = service.update (funcionario);
        return ResponseEntity.noContent ().build ();
    }
    
    @GetMapping()
    public ResponseEntity<List<FuncionarioDTO>> getAllFuncionarios () {
        List<Funcionario> funcionarios = service.getAll ();
        List<FuncionarioDTO> funcionariosDTO = new ArrayList<> ();
        
        for (Funcionario funcionario : funcionarios) {
            FuncionarioDTO funcionarioDTO = mapper.map (funcionario, FuncionarioDTO.class);
            funcionariosDTO.add (funcionarioDTO);
        }
        return ResponseEntity.ok ().body (funcionariosDTO);
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario (@PathVariable Integer id) {
        service.deleteById (id);
        return ResponseEntity.noContent ().build ();
    }
    
    
}
