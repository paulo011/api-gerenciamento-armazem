package com.paulo011.AGA.application.gateways;

import com.paulo011.AGA.domain.entities.Address;
import com.paulo011.AGA.domain.entities.User;
import com.paulo011.AGA.infrastructure.schemes.AddressScheme;
import com.paulo011.AGA.infrastructure.schemes.UserScheme;
import org.springframework.stereotype.Component;

@Component
public class UserGateway {
    public static User toUser(UserScheme userSchema){
        return new User(
                userSchema.getCpf(),
                userSchema.getFirstName(),
                userSchema.getLastName(),
                userSchema.getEmail(),
                new Address(
                        userSchema.getAddress().getZipCode(),
                        userSchema.getAddress().getStreet(),
                        userSchema.getAddress().getDistrict(),
                        userSchema.getAddress().getCity(),
                        userSchema.getAddress().getUf(),
                        userSchema.getAddress().getDdd(),
                        userSchema.getAddress().getComplement()),
                userSchema.getHouse(),
                userSchema.getRoleList());
    }

    public static UserScheme toUserSchema(User user){
        return new UserScheme(
                user.getCpf(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                new AddressScheme(
                        user.getAddress().zipCode(),
                        user.getAddress().street(),
                        user.getAddress().district(),
                        user.getAddress().city(),
                        user.getAddress().uf(),
                        user.getAddress().ddd(),
                        user.getAddress().complement()),
                user.getHouse(),
                user.getRoleList());
    }
}
