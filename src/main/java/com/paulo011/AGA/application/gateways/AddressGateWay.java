package com.paulo011.AGA.application.gateways;

import com.paulo011.AGA.domain.entities.Address;
import com.paulo011.AGA.infrastructure.schemes.AddressScheme;
import org.springframework.stereotype.Component;

@Component
public class AddressGateWay {
    public static Address toAddress(AddressScheme addressSchema){
        return new Address(
                addressSchema.getZipCode(),
                addressSchema.getStreet(),
                addressSchema.getDistrict(),
                addressSchema.getCity(),
                addressSchema.getUf(),
                addressSchema.getDdd(),
                addressSchema.getComplement()
        );
    }
    public static AddressScheme toAddressSchema(Address address){
        return new AddressScheme(
                address.zipCode(),
                address.street(),
                address.district(),
                address.city(),
                address.uf(),
                address.ddd(),
                address.complement()
        );
    }
}
