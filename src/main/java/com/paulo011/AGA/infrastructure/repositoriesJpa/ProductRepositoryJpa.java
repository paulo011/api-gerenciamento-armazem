package com.paulo011.AGA.infrastructure.repositoriesJpa;

import com.paulo011.AGA.infrastructure.schemes.ProductScheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepositoryJpa extends JpaRepository<ProductScheme, UUID> {
}
