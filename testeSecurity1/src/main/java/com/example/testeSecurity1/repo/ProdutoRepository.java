package com.example.testeSecurity1.repo;

import com.example.testeSecurity1.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    List<Produto> findAll();

    @Override
    Optional<Produto> findById(Long id);
}
