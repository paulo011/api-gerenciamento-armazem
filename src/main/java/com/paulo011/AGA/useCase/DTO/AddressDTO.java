package com.paulo011.AGA.useCase.DTO;

public record AddressDTO(String cep,
                         String logradouro,
                         String bairro,
                         String localidade,
                         String uf,
                         Integer ddd,
                         String complemento) {
}
