package com.paulo011.AGA.useCase;

import com.paulo011.AGA.domain.entities.Address;
import com.paulo011.AGA.domain.repositories.AddressRepository;
import com.paulo011.AGA.useCase.DTO.AddressDTO;
import com.paulo011.AGA.useCase.clientsInterface.AddressClientInterface;

public class AddressUseCase {
    private final AddressClientInterface addressClient;
    private final AddressRepository addressRepository;

    public AddressUseCase(AddressClientInterface addressClient,
                          AddressRepository addressRepository){
        this.addressClient = addressClient;
        this.addressRepository = addressRepository;
    }

    public Address createAddress(String zipCode){
         AddressDTO addressDTO = addressClient.searchZipCode(zipCode);
        Address address = new Address(
                addressDTO.cep(),
                addressDTO.logradouro(),
                addressDTO.bairro(),
                addressDTO.localidade(),
                addressDTO.uf(),
                addressDTO.ddd(),
                addressDTO.complemento());

        addressRepository.save(address);
        return address;
    }
}
