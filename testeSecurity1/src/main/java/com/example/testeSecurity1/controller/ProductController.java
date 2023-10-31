package com.example.testeSecurity1.controller;

import com.example.testeSecurity1.model.Produto;
import com.example.testeSecurity1.serv.ProductService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/produtos")
    public ResponseEntity getCarros(){
        List<Produto> produtos = productService.getProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity getCarroById(@PathVariable Long id){
        Optional<Produto> produto = productService.getUnicoProduto(id);
        return ResponseEntity.ok(produto.get());
    }

    @DeleteMapping("/produtos/{id}")
    @RolesAllowed("ADMIN")
    public ResponseEntity delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
