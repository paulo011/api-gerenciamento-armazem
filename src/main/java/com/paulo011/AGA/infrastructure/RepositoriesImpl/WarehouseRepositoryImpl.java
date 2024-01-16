package com.paulo011.AGA.infrastructure.RepositoriesImpl;

import com.paulo011.AGA.application.gateways.WarehouseGateway;
import com.paulo011.AGA.domain.entities.Warehouse;
import com.paulo011.AGA.domain.repositories.WarehouseRepository;
import com.paulo011.AGA.infrastructure.repositoriesJpa.WarehouseRepositoryJpa;
import com.paulo011.AGA.infrastructure.schemes.WarehouseScheme;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class WarehouseRepositoryImpl implements WarehouseRepository {
    private final WarehouseRepositoryJpa warehouseRepositoryInfra;

    public WarehouseRepositoryImpl(WarehouseRepositoryJpa warehouseRepositoryInfra){
        this.warehouseRepositoryInfra = warehouseRepositoryInfra;
    }

    @Override
    public void save(Warehouse warehouse) {
        WarehouseScheme warehouseScheme = WarehouseGateway.toWarehouseScheme(warehouse);
        warehouseRepositoryInfra.save(warehouseScheme);
    }

    @Override
    public List<Warehouse> findAll() {
         return warehouseRepositoryInfra.findAll().stream()
                 .map(WarehouseGateway::toWarehouse)
                 .toList();
    }

    @Override
    public Warehouse findById(UUID id) {
        Optional<WarehouseScheme> warehouseSchemeOptional = warehouseRepositoryInfra.findById(id);
        if(warehouseSchemeOptional.isEmpty())
            throw new RuntimeException("Warehouse not found");
        return WarehouseGateway.toWarehouse(warehouseSchemeOptional.get());
    }

    @Override
    public void saveAndFlush(Warehouse warehouse) {
        WarehouseScheme warehouseScheme = WarehouseGateway.toWarehouseScheme(warehouse);
        warehouseRepositoryInfra.saveAndFlush(warehouseScheme);
    }

    @Override
    public void delete(UUID id) {
        warehouseRepositoryInfra.deleteById(id);
    }
}
