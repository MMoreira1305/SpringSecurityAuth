package com.example.testeSecurity1.serv;

import com.example.testeSecurity1.exception.ObjectNotFoundException;
import com.example.testeSecurity1.model.Produto;
import com.example.testeSecurity1.repo.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> getUnicoProduto(@PathVariable Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        Produto produto1 = new Produto();
        return produto.map(produto2 -> produto).orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado"));
    }

    public void delete(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }

}
