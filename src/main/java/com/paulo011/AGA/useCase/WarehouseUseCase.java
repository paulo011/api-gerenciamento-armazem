package com.paulo011.AGA.useCase;

import com.paulo011.AGA.domain.entities.Warehouse;
import com.paulo011.AGA.domain.repositories.WarehouseRepository;
import com.paulo011.AGA.useCase.DTO.UpdateRequestDTO;
import com.paulo011.AGA.useCase.DTO.WarehouseRequestDTO;
import com.paulo011.AGA.useCase.DTO.WarehouseResponseDTO;

import java.util.*;

public class WarehouseUseCase {
    private final WarehouseRepository warehouseRepository;

    public WarehouseUseCase(WarehouseRepository warehouseRepository){
        this.warehouseRepository = warehouseRepository;
    }

    public static Map<String, String> mapGeneratorForUser(Warehouse warehouse){
        Map<String, String> usersMap = new HashMap<>();
        warehouse.getUserList().forEach(
                user -> usersMap.putIfAbsent(user.getCpf(), user.getFirstName()));
        return usersMap;
    }

    public static Map<UUID, String> mapGeneratorForProduct(Warehouse warehouse){
        Map<UUID, String> productsMap = new HashMap<>();
        warehouse.getProductList().forEach(
                product -> productsMap.putIfAbsent(product.getCode(), product.getName()));
        return productsMap;
    }

    public void createWarehouse(WarehouseRequestDTO warehouseRequestDTO){
        Warehouse warehouse = new Warehouse(
                null,
                warehouseRequestDTO.name(),
                new ArrayList<>(),
                new ArrayList<>());

        warehouseRepository.save(warehouse);
    }

    public List<WarehouseResponseDTO> findAllWarehouses(){
        List<Warehouse> warehouseList = warehouseRepository.findAll();

        return warehouseList.stream().map(warehouse ->
                new WarehouseResponseDTO(
                        warehouse.getId(),
                        warehouse.getName(),
                        mapGeneratorForUser(warehouse),
                        mapGeneratorForProduct(warehouse)
                )).toList();
    }

    public WarehouseResponseDTO findWarehouse(UUID warehouseId){
        Warehouse warehouse = warehouseRepository.findById(warehouseId);

        return new WarehouseResponseDTO(
                warehouse.getId(),
                warehouse.getName(),
                mapGeneratorForUser(warehouse),
                mapGeneratorForProduct(warehouse));
    }

    public void updateWarehouse(UUID id, UpdateRequestDTO updateRequestDTO){
        Warehouse warehouse = warehouseRepository.findById(id);
        warehouse.setName(updateRequestDTO.requestedUserList().get("name"));
        warehouseRepository.saveAndFlush(warehouse);
    }


}
