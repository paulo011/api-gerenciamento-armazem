package com.paulo011.AGA.useCase.DTO;

import com.paulo011.AGA.domain.constants.Status;
import com.paulo011.AGA.domain.entities.Category;
import com.paulo011.AGA.domain.entities.Product;

import java.util.UUID;

public record ProductResponseDTO(UUID code,
                                 String name,
                                 String description,
                                 Double value,
                                 Float weight,
                                 Float width,
                                 Float height,
                                 Category category,
                                 Status status) {
    public ProductResponseDTO(Product product){
        this(
                product.getCode(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getWeight(),
                product.getWidth(),
                product.getHeight(),
                product.getCategory(),
                product.getStatus()
                );
    }
}
