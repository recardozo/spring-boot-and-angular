package com.payhere.resources;

import com.payhere.domain.Fornecedor;
import com.payhere.dto.FornecedorDTO;
import com.payhere.services.FornecedorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("fornecedores")
public class FornecedorResource {
    
    
    @Autowired
    FornecedorService service;
    
    ModelMapper mapper = new ModelMapper ();
    
    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> getFornecedor (@PathVariable Integer id) {
        Fornecedor fornecedor = service.getById (id);
        FornecedorDTO fornecedorDTO = mapper.map (fornecedor, FornecedorDTO.class);
        return ResponseEntity.ok ().body (fornecedorDTO);
    }
    
    @PostMapping
    public ResponseEntity<Fornecedor> createFornecedor (@RequestBody FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = mapper.map (fornecedorDTO, Fornecedor.class);
        fornecedor = service.save (fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}").buildAndExpand (fornecedor.getId ()).toUri ();
        return ResponseEntity.created (uri).build ();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FornecedorDTO> updateaFornecedor (@RequestBody FornecedorDTO fornecedorDTO, @PathVariable Integer id) {
        Fornecedor fornecedor = mapper.map (fornecedorDTO, Fornecedor.class);
        fornecedor.setId (id);
        fornecedor = service.update (fornecedor);
        return ResponseEntity.noContent ().build ();
    }
    
    @GetMapping()
    public ResponseEntity<List<FornecedorDTO>> getAllFornecedores () {
        List<Fornecedor> fornecedores = service.getAll ();
        List<FornecedorDTO> fornecedoresDTO = new ArrayList<> ();
        
        for (Fornecedor fornecedor : fornecedores) {
            FornecedorDTO fornecedorDTO = mapper.map (fornecedor, FornecedorDTO.class);
            fornecedoresDTO.add (fornecedorDTO);
        }
        return ResponseEntity.ok ().body (fornecedoresDTO);
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFornecedor (@PathVariable Integer id) {
        service.deleteById (id);
        return ResponseEntity.noContent ().build ();
    }
    
    
}
