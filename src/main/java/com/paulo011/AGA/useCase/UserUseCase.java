package com.paulo011.AGA.useCase;

import com.paulo011.AGA.domain.entities.Address;
import com.paulo011.AGA.domain.entities.User;
import com.paulo011.AGA.domain.repositories.UserRepository;
import com.paulo011.AGA.useCase.DTO.UserRequestDTO;
import com.paulo011.AGA.useCase.DTO.UserResponseDTO;
import com.paulo011.AGA.useCase.DTO.UpdateRequestDTO;

import java.util.List;

public class UserUseCase {
    private final UserRepository userRepository;
    private final AddressUseCase addressUseCase;

    public UserUseCase(UserRepository userRepository,
                       AddressUseCase addressUseCase){
        this.userRepository = userRepository;
        this.addressUseCase = addressUseCase;
    }

    public void createUser(UserRequestDTO userRequestDTO){
        Address address = addressUseCase.createAddress(userRequestDTO.zipCode());

        User user = new User(
                userRequestDTO.cpf(),
                userRequestDTO.firstName(),
                userRequestDTO.lastName(),
                userRequestDTO.email(),
                address,
                userRequestDTO.house(),
                userRequestDTO.roleList());

        userRepository.save(user);
    }

    public List<UserResponseDTO> findAllUsers(){
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserResponseDTO::new).toList();
    }

    public UserResponseDTO findUserByCpf(String cpf){
        User user = userRepository.findByCpf(cpf);
        return new UserResponseDTO(user);
    }

    public void updateUser(String cpf, UpdateRequestDTO UpdateRequestDTO){
        User user = userRepository.findByCpf(cpf);
        UpdateRequestDTO.requestedUserList()
                .forEach((key, value) -> {
            switch (key){
                case "firstName": user.setFirstName(value);
                break;
                case "lastName": user.setLastName(value);
                break;
                case "email": user.setEmail(value);
                break;
                case "address": addressUseCase.createAddress(value);
                break;
                case "house": user.setHouse(value);
                break;
                default: throw new RuntimeException("List for updates empty");
            }
        });

        userRepository.saveAndFlush(user);
    }

    public void deleteUser(String cpf){
        User user = userRepository.findByCpf(cpf);
        user.setRoleList(null);
        userRepository.saveAndFlush(user);
    }

}
