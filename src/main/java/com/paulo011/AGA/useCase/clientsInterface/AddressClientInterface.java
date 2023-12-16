package com.paulo011.AGA.useCase.clientsInterface;

import com.paulo011.AGA.useCase.DTO.AddressDTO;

public interface AddressClientInterface {
    AddressDTO searchZipCode(String zipCode);
}
