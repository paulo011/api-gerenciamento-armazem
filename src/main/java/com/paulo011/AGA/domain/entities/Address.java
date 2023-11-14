package com.paulo011.AGA.domain.entities;

public record Address(String zipCode,
                      String street,
                      String district,
                      String city,
                      String uf,
                      Integer ddd,
                      String complement) {
}
