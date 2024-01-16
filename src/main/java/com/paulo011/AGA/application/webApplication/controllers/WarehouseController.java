package com.paulo011.AGA.application.webApplication.controllers;

import com.paulo011.AGA.useCase.DTO.UpdateRequestDTO;
import com.paulo011.AGA.useCase.DTO.WarehouseRequestDTO;
import com.paulo011.AGA.useCase.DTO.WarehouseResponseDTO;
import com.paulo011.AGA.useCase.WarehouseUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/warehouse")
public class WarehouseController {
    private final WarehouseUseCase warehouseUseCase;

    public WarehouseController(WarehouseUseCase warehouseUseCase){
        this.warehouseUseCase = warehouseUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createWarehouse(@RequestBody WarehouseRequestDTO warehouseRequestDTO){
        try{
            warehouseUseCase.createWarehouse(warehouseRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllWarehouse(){
        try {
            List<WarehouseResponseDTO> warehouseResponseDTOS = warehouseUseCase.findAllWarehouses();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(warehouseResponseDTOS);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findWarehouseById(@PathVariable("id") UUID id){
        try {
            WarehouseResponseDTO warehouseResponseDTO = warehouseUseCase.findWarehouse(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(warehouseResponseDTO);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateWarehouse(@PathVariable("id") UUID id,
                                             @RequestBody UpdateRequestDTO updateRequestDTO){
        try {
            warehouseUseCase.updateWarehouse(id, updateRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

}
