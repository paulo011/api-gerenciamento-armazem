package com.paulo011.AGA.application.webApplication.Clients;

import com.paulo011.AGA.useCase.DTO.AddressDTO;
import com.paulo011.AGA.useCase.clientsInterface.AddressClientInterface;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viacep", url = "viacep.com.br/ws/")
public interface AddressClient extends AddressClientInterface {
    @GetMapping(value = "{id}/json/")
    AddressDTO searchZipCode(@PathVariable("id") String id);
}