package com.paulo011.AGA.application.webApplication.controllers;

import com.paulo011.AGA.useCase.CategoryUseCase;
import com.paulo011.AGA.useCase.DTO.CategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    private final CategoryUseCase categoryUseCase;

    public CategoryController(CategoryUseCase categoryUseCase) {
        this.categoryUseCase = categoryUseCase;
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<?> findCategoryByName(@PathVariable("name") String name){
        try {
            CategoryDTO categoryDTO = categoryUseCase.findCategoryByName(name);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(categoryDTO);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllCategory(){
        try {
            List<CategoryDTO> categoryDTOList = categoryUseCase.findAllCategories();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(categoryDTOList);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
