package com.paulo011.AGA.useCase.DTO;

import com.paulo011.AGA.domain.entities.Historic;
import com.paulo011.AGA.domain.entities.Product;
import com.paulo011.AGA.domain.entities.User;

import java.util.Date;
import java.util.UUID;

public record HistoricResponseDTO(UUID id,
                                  User User,
                                  Product product,
                                  Date date,
                                  String description){

    public HistoricResponseDTO(Historic historic) {
        this(
                historic.id(),
                historic.User(),
                historic.product(),
                historic.date(),
                historic.description()
        );
    }
}
