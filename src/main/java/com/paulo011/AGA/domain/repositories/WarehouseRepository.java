package com.paulo011.AGA.domain.repositories;

import com.paulo011.AGA.domain.entities.Warehouse;

import java.util.List;
import java.util.UUID;

public interface WarehouseRepository {
    void save(Warehouse warehouse);
    List<Warehouse> findAll();
    Warehouse findById(UUID id);
    void saveAndFlush(Warehouse warehouse);
    void delete(UUID id);
}
