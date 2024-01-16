package com.paulo011.AGA.application.gateways;

import com.paulo011.AGA.domain.entities.Category;
import com.paulo011.AGA.infrastructure.schemes.CategoryScheme;
import org.springframework.stereotype.Component;

@Component
public class CategoryGateway {
    public static Category toCategory(CategoryScheme categoryScheme){
        return new Category(categoryScheme.getTYPE());
    }

    public static CategoryScheme toCategoryScheme(Category category){
        return new CategoryScheme(category.type());
    }
}
