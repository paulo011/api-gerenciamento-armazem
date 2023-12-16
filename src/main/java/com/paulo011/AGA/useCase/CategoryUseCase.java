package com.paulo011.AGA.useCase;

import com.paulo011.AGA.domain.entities.Category;
import com.paulo011.AGA.domain.repositories.CategoryRepository;
import com.paulo011.AGA.useCase.DTO.CategoryDTO;

import java.util.List;

public class CategoryUseCase {
    private final CategoryRepository categoryRepository;

    public CategoryUseCase(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(String type){
        Category category = new Category(type);
        categoryRepository.save(category);
        return category;
    }

    public Category findCategoryByType(String type){
        return categoryRepository.findById(type);
    }

    public List<CategoryDTO> findAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryDTO::new)
                .toList();
    }

    public CategoryDTO findCategoryByName(String name){
        Category category = categoryRepository.findById(name);
        return new CategoryDTO(category);
    }

    public void deleteCategory(String type){
        categoryRepository.delete(type);
    }
}
