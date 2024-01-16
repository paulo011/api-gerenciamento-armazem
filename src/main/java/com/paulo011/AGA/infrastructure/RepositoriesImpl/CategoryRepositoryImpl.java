package com.paulo011.AGA.infrastructure.RepositoriesImpl;

import com.paulo011.AGA.application.gateways.CategoryGateway;
import com.paulo011.AGA.domain.entities.Category;
import com.paulo011.AGA.domain.repositories.CategoryRepository;
import com.paulo011.AGA.infrastructure.repositoriesJpa.CategoryRepositoryJpa;
import com.paulo011.AGA.infrastructure.schemes.CategoryScheme;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {
    private final CategoryRepositoryJpa categoryRepositoryInfra;

    public CategoryRepositoryImpl(CategoryRepositoryJpa categoryRepositoryInfra){
        this.categoryRepositoryInfra = categoryRepositoryInfra;
    }

    @Override
    public void save(Category category) {
        CategoryScheme categoryScheme = CategoryGateway.toCategoryScheme(category);
        categoryRepositoryInfra.save(categoryScheme);
    }

    @Override
    public Category findById(String id) {
        Optional<CategoryScheme> categorySchemeOptional = categoryRepositoryInfra.findById(id);
        if (categorySchemeOptional.isEmpty())
            throw new RuntimeException("Category not found");
        return CategoryGateway.toCategory(categorySchemeOptional.get());
    }

    @Override
    public List<Category> findAll() {
        List<CategoryScheme> categorySchemeList = categoryRepositoryInfra.findAll();
        return categorySchemeList.stream()
                .map(CategoryGateway::toCategory)
                .toList();
    }

    @Override
    public void delete(String id) {
        categoryRepositoryInfra.deleteById(id);
    }
}
