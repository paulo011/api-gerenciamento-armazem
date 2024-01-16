package com.paulo011.AGA.application.webApplication.controllers;

import com.paulo011.AGA.useCase.DTO.UpdateRequestDTO;
import com.paulo011.AGA.useCase.DTO.UserRequestDTO;
import com.paulo011.AGA.useCase.DTO.UserResponseDTO;
import com.paulo011.AGA.useCase.UserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase){
        this.userUseCase = userUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequestDTO){
        try{
            userUseCase.createUser(userRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<?> findUserByCpf(@PathVariable("cpf") String cpf){
        try{
            UserResponseDTO userResponseDTO = userUseCase.findUserByCpf(cpf);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(userResponseDTO);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllUsersByCpf(){
        try{
            List<UserResponseDTO> usersResponseDTO = userUseCase.findAllUsers();
            return ResponseEntity.status(HttpStatus.OK).body(usersResponseDTO);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping(value = "/{cpf}")
    public ResponseEntity<?> updateUserByCpf(@PathVariable("cpf") String cpf,
                                             @RequestBody UpdateRequestDTO updateRequestDTO){
        try {
            userUseCase.updateUser(cpf, updateRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity<?> deleteUserByCpf(@PathVariable("cpf") String cpf){
        try {
            userUseCase.deleteUser(cpf);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
