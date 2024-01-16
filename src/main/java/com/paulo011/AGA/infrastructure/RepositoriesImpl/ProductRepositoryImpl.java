package com.paulo011.AGA.infrastructure.RepositoriesImpl;

import com.paulo011.AGA.application.gateways.ProductGateway;
import com.paulo011.AGA.domain.entities.Product;
import com.paulo011.AGA.domain.repositories.ProductRepository;
import com.paulo011.AGA.infrastructure.repositoriesJpa.ProductRepositoryJpa;
import com.paulo011.AGA.infrastructure.schemes.ProductScheme;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductRepositoryJpa productRepositoryInfra;

    public ProductRepositoryImpl(ProductRepositoryJpa productRepositoryInfra){
        this.productRepositoryInfra = productRepositoryInfra;
    }

    @Override
    public void save(Product product) {
        ProductScheme productScheme = ProductGateway.toProductScheme(product);
        productRepositoryInfra.save(productScheme);
    }

    @Override
    public List<Product> findAll() {
        List<ProductScheme> productSchemeList = productRepositoryInfra.findAll();
        return productSchemeList.stream()
                .map(ProductGateway::toProduct).toList();
    }

    @Override
    public Product findById(UUID id) {
        Optional<ProductScheme> productSchemeOptional = productRepositoryInfra.findById(id);
        if (productSchemeOptional.isEmpty())
            throw new RuntimeException("Product not found");
        return ProductGateway.toProduct(productSchemeOptional.get());
    }

    @Override
    public void delete(UUID id) {
        productRepositoryInfra.deleteById(id);
    }

    @Override
    public void saveAndFlush(Product product) {
        ProductScheme productScheme = ProductGateway.toProductScheme(product);
        productRepositoryInfra.saveAndFlush(productScheme);
    }
}
