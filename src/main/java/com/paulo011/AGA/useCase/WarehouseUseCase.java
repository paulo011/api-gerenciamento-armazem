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

        Map<String, String> usersMap = new HashMap<>();
        Map<UUID, String> productsMap = new HashMap<>();
        warehouseList.forEach(warehouse -> {
            warehouse.getUserList().forEach(user ->
                    usersMap.putIfAbsent(user.getCpf(), user.getFirstName()));
            warehouse.getProductList().forEach(product ->
                    productsMap.putIfAbsent(product.getCode(), product.getName()));
        });

        return warehouseList.stream().map(warehouse ->
                new WarehouseResponseDTO(
                        warehouse.getId(),
                        warehouse.getName(),
                        usersMap,
                        productsMap
                )).toList();
    }

    public WarehouseResponseDTO findWarehouse(UUID warehouseId){
        Warehouse warehouse = warehouseRepository.findById(warehouseId);

        Map<String, String>usersMap = new HashMap<>();
        Map<UUID, String> productsMap = new HashMap<>();
        warehouse.getUserList().forEach(
                user -> usersMap.putIfAbsent(user.getCpf(), user.getFirstName()));
        warehouse.getProductList().forEach(
                product -> productsMap.putIfAbsent(product.getCode(), product.getName()));

        return new WarehouseResponseDTO(
                warehouse.getId(),
                warehouse.getName(),
                usersMap,
                productsMap);
    }

    public void updateWarehouse(UUID id, UpdateRequestDTO updateRequestDTO){
        Warehouse warehouse = warehouseRepository.findById(id);
        warehouse.setName(updateRequestDTO.requestedUserList().get("name"));
        warehouseRepository.saveAndFlush(warehouse);
    }


}
