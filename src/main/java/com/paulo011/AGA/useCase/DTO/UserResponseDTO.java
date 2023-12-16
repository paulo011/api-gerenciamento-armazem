package com.paulo011.AGA.useCase.DTO;

import com.paulo011.AGA.domain.constants.Role;
import com.paulo011.AGA.domain.entities.User;

import java.util.List;

public record UserResponseDTO(String cpf,
                              String firstName,
                              String lastName,
                              String email,
                              String zipCode,
                              String house,
                              List<Role> roleList){
    public UserResponseDTO(User user){
        this(
                user.getCpf(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAddress().zipCode(),
                user.getHouse(),
                user.getRoleList()
        );
    }
}
