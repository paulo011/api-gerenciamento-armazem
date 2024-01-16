package com.paulo011.AGA.application.webApplication.controllers;

import com.paulo011.AGA.useCase.DTO.HistoricResponseDTO;
import com.paulo011.AGA.useCase.HistoricUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController(value = "/historic")
public class HistoricController {
    private final HistoricUseCase historicUseCase;

    public HistoricController(HistoricUseCase historicUseCase) {
        this.historicUseCase = historicUseCase;
    }

    @GetMapping
    public ResponseEntity<?> findAllHistoric(){
        try {
            List<HistoricResponseDTO> allHistoric = historicUseCase.findAllHistoric();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(allHistoric);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<?> findHistoricByUser(@PathVariable("cpf") String cpf){
        try {
            List<HistoricResponseDTO> historicByUserList = historicUseCase.findHistoricByUser(cpf);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(historicByUserList);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<?> findHistoricByProduct(@PathVariable("code") UUID code){
        try {
            List<HistoricResponseDTO> historicByProductList = historicUseCase.findHistoricByProduct(code);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(historicByProductList);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping(value = "/{date}")
    public ResponseEntity<?> findHistoricByDate(@PathVariable("date") Date date){
        try {
            List<HistoricResponseDTO> historicByProductList = historicUseCase.findHistoricByDate(date);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(historicByProductList);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
