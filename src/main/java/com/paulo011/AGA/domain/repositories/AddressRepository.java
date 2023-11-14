package com.paulo011.AGA.domain.repositories;

import com.paulo011.AGA.domain.entities.Address;

import java.util.List;

public interface AddressRepository {
    void save(Address address);
    Address findById(String id);
    List<Address> findAll();
    void delete(String id);
}
