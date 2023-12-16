package com.paulo011.AGA.useCase.DTO;

import com.paulo011.AGA.domain.entities.Warehouse;

import java.util.Map;
import java.util.UUID;

public record WarehouseResponseDTO(UUID id,
                                   String name,
                                   Map<String, String> userList,
                                   Map<UUID, String> productList) {
}
