package com.paulo011.AGA.useCase.DTO;

import com.paulo011.AGA.domain.entities.Category;

public record CategoryDTO(String type) {
    public CategoryDTO(Category category){
        this(category.type());
    }
}
