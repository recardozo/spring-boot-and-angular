package com.payhere.resources;

import com.payhere.domain.Vendedor;
import com.payhere.dto.VendedorDTO;
import com.payhere.services.VendedorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("vendedores")
public class VendedorResource {
    
    
    @Autowired
    VendedorService service;
    
    ModelMapper mapper = new ModelMapper ();
    
    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> getVendedor (@PathVariable Integer id) {
        Vendedor vendedor = service.getById (id);
        VendedorDTO vendedorDTO = mapper.map (vendedor, VendedorDTO.class);
        return ResponseEntity.ok ().body (vendedorDTO);
    }
    
    @PostMapping
    public ResponseEntity<Vendedor> createVendedor (@RequestBody VendedorDTO vendedorDTO) {
        Vendedor vendedor = mapper.map (vendedorDTO, Vendedor.class);
        vendedor = service.save (vendedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}").buildAndExpand (vendedor.getId ()).toUri ();
        return ResponseEntity.created (uri).build ();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<VendedorDTO> updateaVendedor (@RequestBody VendedorDTO vendedorDTO, @PathVariable Integer id) {
        Vendedor vendedor = mapper.map (vendedorDTO, Vendedor.class);
        vendedor.setId (id);
        vendedor=service.update (vendedor);
        return ResponseEntity.noContent ().build ();
    }
    
    @GetMapping()
    public ResponseEntity<List<VendedorDTO>> getAllVendedores () {
        List<Vendedor> vendedores = service.getAll ();
        List<VendedorDTO> vendedoresDTO = new ArrayList<> ();
        
        for (Vendedor vendedor : vendedores) {
            VendedorDTO vendedorDTO = mapper.map (vendedor, VendedorDTO.class);
            vendedoresDTO.add (vendedorDTO);
        }
        return ResponseEntity.ok ().body (vendedoresDTO);
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendedor (@PathVariable Integer id) {
        service.deleteById (id);
        return ResponseEntity.noContent ().build ();
    }
    
    
}
