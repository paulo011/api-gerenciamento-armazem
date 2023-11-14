package com.paulo011.AGA.domain.repositories;

import com.paulo011.AGA.domain.entities.Category;

import java.util.List;

public interface CategoryRepository {
    void save(Category category);
    Category findById(String id);
    List<Category> findAll();
    void delete(String id);
}
