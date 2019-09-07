package com.payhere.resources;

import com.payhere.domain.Marca;
import com.payhere.dto.MarcaDTO;
import com.payhere.services.MarcaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("marcas")
public class MarcaResource {
    
    @Autowired
    MarcaService service;
    
    ModelMapper mapper = new ModelMapper ();
    
    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> getMarca (@PathVariable Integer id) {
        Marca marca = service.getById (id);
        MarcaDTO marcaDTO = mapper.map (marca, MarcaDTO.class);
        return ResponseEntity.ok ().body (marcaDTO);
    }
    
    @PostMapping
    public ResponseEntity<Marca> createMarca (@RequestBody MarcaDTO marcaDTO) {
        Marca marca = mapper.map (marcaDTO, Marca.class);
        marca = service.save (marca);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}").buildAndExpand (marca.getId ()).toUri ();
        return ResponseEntity.created (uri).build ();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO> updateMarca (@RequestBody MarcaDTO marcaDTO, @PathVariable Integer id) {
        Marca marca = mapper.map (marcaDTO, Marca.class);
        marca.setId (id);
        marca = service.update (marca);
        return ResponseEntity.noContent ().build ();
    }
    
    @GetMapping()
    public ResponseEntity<List<MarcaDTO>> getAllMarcas () {
        List<Marca> marcas = service.getAll ();
        List<MarcaDTO> marcasdDtos = new ArrayList<> ();
        
        for (Marca marca : marcas) {
            MarcaDTO marcaDto = mapper.map (marca, MarcaDTO.class);
            marcasdDtos.add (marcaDto);
        }
        
        return ResponseEntity.ok ().body (marcasdDtos);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarca (@PathVariable Integer id) {
        service.deleteById (id);
        return ResponseEntity.noContent ().build ();
    }
}
