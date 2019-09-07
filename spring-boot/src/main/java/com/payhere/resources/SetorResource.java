package com.payhere.resources;

import com.payhere.domain.Setor;
import com.payhere.dto.SetorDTO;
import com.payhere.services.SetorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("setores")
public class SetorResource {
    
    @Autowired
    SetorService service;
    
    ModelMapper mapper = new ModelMapper ();
    
    @GetMapping("/{id}")
    public ResponseEntity<SetorDTO> getSetor (@PathVariable Integer id) {
        Setor setor = service.getById (id);
        SetorDTO setorDTO = mapper.map (setor, SetorDTO.class);
        return ResponseEntity.ok ().body (setorDTO);
    }
    
    @PostMapping
    public ResponseEntity<Setor> createSetor (@RequestBody SetorDTO setorDTO) {
        Setor setor = mapper.map (setorDTO, Setor.class);
        setor = service.save (setor);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}").buildAndExpand (setor.getId ()).toUri ();
        return ResponseEntity.created (uri).build ();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SetorDTO> updateSetor (@RequestBody SetorDTO setorDTO, @PathVariable Integer id) {
        Setor setor = mapper.map (setorDTO, Setor.class);
        setor.setId (id);
        setor = service.update (setor);
        return ResponseEntity.noContent ().build ();
    }
    
    @GetMapping()
    public ResponseEntity<List<SetorDTO>> getAllSetores () {
        List<Setor> setores = service.getAll ();
        List<SetorDTO> setoresDTO = new ArrayList<> ();
        
        for (Setor setor : setores) {
            SetorDTO setorDTO = mapper.map (setor, SetorDTO.class);
            setoresDTO.add (setorDTO);
        }
        
        return ResponseEntity.ok ().body (setoresDTO);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSetor (@PathVariable Integer id) {
        service.deleteById (id);
        return ResponseEntity.noContent ().build ();
    }
    
}
