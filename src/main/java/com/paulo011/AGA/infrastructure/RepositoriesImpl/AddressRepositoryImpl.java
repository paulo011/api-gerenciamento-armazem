package com.paulo011.AGA.infrastructure.RepositoriesImpl;

import com.paulo011.AGA.application.gateways.AddressGateWay;
import com.paulo011.AGA.domain.entities.Address;
import com.paulo011.AGA.domain.repositories.AddressRepository;
import com.paulo011.AGA.infrastructure.repositoriesJpa.AddressRepositoryJpa;
import com.paulo011.AGA.infrastructure.schemes.AddressScheme;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class AddressRepositoryImpl implements AddressRepository {
    private final AddressRepositoryJpa addressRepositoryInfra;

    public AddressRepositoryImpl(AddressRepositoryJpa addressRepositoryInfra){
        this.addressRepositoryInfra = addressRepositoryInfra;
    }

    @Override
    public void save(Address address) {
        AddressScheme addressSchema = AddressGateWay.toAddressSchema(address);
        addressRepositoryInfra.save(addressSchema);
    }

    @Override
    public Address findById(String id) {
        Optional<AddressScheme> addressSchemeOptional = addressRepositoryInfra.findById(id);
        if(addressSchemeOptional.isEmpty())
            throw new RuntimeException("Address not found");
        return AddressGateWay.toAddress(addressSchemeOptional.get());
    }

    @Override
    public List<Address> findAll() {
        List<AddressScheme> addressSchemeList = addressRepositoryInfra.findAll();
        return addressSchemeList.stream()
                .map(AddressGateWay::toAddress).toList();
    }

    @Override
    public void delete(String id) {
        addressRepositoryInfra.deleteById(id);
    }
}
