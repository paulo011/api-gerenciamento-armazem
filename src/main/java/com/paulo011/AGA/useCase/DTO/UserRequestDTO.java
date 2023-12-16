package com.paulo011.AGA.useCase.DTO;

import com.paulo011.AGA.domain.constants.Role;

import java.util.List;

public record UserRequestDTO (String cpf,
                              String firstName,
                              String lastName,
                              String email,
                              String zipCode,
                              String house,
                              List<Role> roleList){
}
