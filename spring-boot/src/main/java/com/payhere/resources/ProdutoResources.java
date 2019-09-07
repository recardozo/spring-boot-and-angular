package com.payhere.resources;

import com.payhere.domain.Produto;
import com.payhere.dto.ProdutoDTO;
import com.payhere.services.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoResources {
    
    @Autowired
    ProdutoService service;
    
    ModelMapper mapper = new ModelMapper ();
    
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProduto (@PathVariable Integer id) {
        Produto produto = service.getById (id);
        ProdutoDTO produtoDTO = mapper.map (produto, ProdutoDTO.class);
        return ResponseEntity.ok ().body (produtoDTO);
    }
    
    @PostMapping
    public ResponseEntity<Produto> createProduto (@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = mapper.map (produtoDTO, Produto.class);
        produto = service.save (produto);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}").buildAndExpand (produto.getId ()).toUri ();
        return ResponseEntity.created (uri).build ();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> updateProduto (@RequestBody ProdutoDTO produtoDTO, @PathVariable Integer id) {
        Produto produto = mapper.map (produtoDTO, Produto.class);
        produto.setId (id);
        produto = service.update (produto);
        return ResponseEntity.noContent ().build ();
    }
    
    @GetMapping()
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos () {
        List<Produto> produtos = service.getAll ();
        List<ProdutoDTO> produtosDTO = new ArrayList<> ();
        
        for (Produto produto : produtos) {
            ProdutoDTO produtoDTO = mapper.map (produto, ProdutoDTO.class);
            produtosDTO.add (produtoDTO);
        }
        
        return ResponseEntity.ok ().body (produtosDTO);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto (@PathVariable Integer id) {
        service.deleteById (id);
        return ResponseEntity.noContent ().build ();
    }
    
}
