package com.paulo011.AGA.application.webApplication.controllers;

import com.paulo011.AGA.useCase.DTO.ProductRequestDTO;
import com.paulo011.AGA.useCase.DTO.ProductResponseDTO;
import com.paulo011.AGA.useCase.DTO.UpdateRequestDTO;
import com.paulo011.AGA.useCase.ProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase){
        this.productUseCase = productUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        try {
            productUseCase.createProduct(productRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<?> findProductByCode(@PathVariable("code") UUID code){
        ProductResponseDTO productResponseDTO = productUseCase.findProductByCode(code);
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productResponseDTO);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllProduct(){
        try {
            List<ProductResponseDTO> allProductsResponseDTO = productUseCase.findAllProducts();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(allProductsResponseDTO);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping(value = "/{code}")
    public ResponseEntity<?> updateProduct(@PathVariable("code") UUID code,
                                           @RequestBody UpdateRequestDTO updateRequestDTO){
        try {
            productUseCase.updateProduct(code, updateRequestDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<String> deleteProduct(@PathVariable("code") UUID code){
        try {
            productUseCase.deleteProduct(code);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
