package com.payhere.resources;

import com.payhere.domain.Departamento;
import com.payhere.dto.DepartamentoDTO;
import com.payhere.services.DepartamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("departamentos")
public class DepartamentoResource {
    
    
    @Autowired
    DepartamentoService service;
    
    ModelMapper mapper = new ModelMapper ();
    
    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> getDepartamento (@PathVariable Integer id) {
        Departamento departamento = service.getById (id);
        DepartamentoDTO departamentoDTO = mapper.map (departamento, DepartamentoDTO.class);
        return ResponseEntity.ok ().body (departamentoDTO);
    }
    
    @PostMapping
    public ResponseEntity<Departamento> createDepartamento (@RequestBody DepartamentoDTO departamentoDTO) {
        Departamento departamento = mapper.map (departamentoDTO, Departamento.class);
        departamento = service.save (departamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}").buildAndExpand (departamento.getId ()).toUri ();
        return ResponseEntity.created (uri).build ();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> updateaDepartamento (@RequestBody DepartamentoDTO departamentoDTO, @PathVariable Integer id) {
        Departamento departamento = mapper.map (departamentoDTO, Departamento.class);
        departamento.setId (id);
        departamento = service.update (departamento);
        return ResponseEntity.noContent ().build ();
    }
    
    @GetMapping()
    public ResponseEntity<List<DepartamentoDTO>> getAllDepartamentos () {
        List<Departamento> departamentos = service.getAll ();
        List<DepartamentoDTO> departamentosDTO = new ArrayList<> ();
        
        for (Departamento departamento : departamentos) {
            DepartamentoDTO departamentoDTO = mapper.map (departamento, DepartamentoDTO.class);
            departamentosDTO.add (departamentoDTO);
        }
        return ResponseEntity.ok ().body (departamentosDTO);
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartamento (@PathVariable Integer id) {
        service.deleteById (id);
        return ResponseEntity.noContent ().build ();
    }
    
    
}
