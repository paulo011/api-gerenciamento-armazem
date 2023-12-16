package com.paulo011.AGA.useCase.DTO;

import com.paulo011.AGA.domain.constants.Status;
import com.paulo011.AGA.domain.entities.Category;

public record ProductRequestDTO(String name,
                                String description,
                                Double price,
                                Float weight,
                                Float width,
                                Float height,
                                Category category,
                                Status status,
                                String cpfUser,
                                String descriptionForHistoric) {
}
