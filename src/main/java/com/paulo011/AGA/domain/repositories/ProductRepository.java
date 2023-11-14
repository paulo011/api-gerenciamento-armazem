package com.paulo011.AGA.domain.repositories;

import com.paulo011.AGA.domain.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    void save(Product product);
    List<Product> findAll();
    Product findById(UUID id);
    void delete(UUID id);
    void saveAndFlush(Product product);
}
