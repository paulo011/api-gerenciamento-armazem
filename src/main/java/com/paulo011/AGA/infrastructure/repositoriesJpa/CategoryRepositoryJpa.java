package com.paulo011.AGA.infrastructure.repositoriesJpa;

import com.paulo011.AGA.infrastructure.schemes.CategoryScheme;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepositoryJpa extends JpaRepository<CategoryScheme, String> {
}
