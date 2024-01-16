package com.paulo011.AGA.application.gateways;

import com.paulo011.AGA.domain.entities.*;
import com.paulo011.AGA.infrastructure.schemes.*;
import org.springframework.stereotype.Component;

@Component
public class HistoricGateway {
    public static Historic toHistoric(HistoricScheme historicScheme){
        return new Historic(
                historicScheme.getId(),
                new User(
                        historicScheme.getUser().getCpf(),
                        historicScheme.getUser().getFirstName(),
                        historicScheme.getUser().getLastName(),
                        historicScheme.getUser().getEmail(),
                        new Address(
                                historicScheme.getUser().getAddress().getZipCode(),
                                historicScheme.getUser().getAddress().getStreet(),
                                historicScheme.getUser().getAddress().getDistrict(),
                                historicScheme.getUser().getAddress().getCity(),
                                historicScheme.getUser().getAddress().getUf(),
                                historicScheme.getUser().getAddress().getDdd(),
                                historicScheme.getUser().getAddress().getComplement()
                                ),
                        historicScheme.getUser().getHouse(),
                        historicScheme.getUser().getRoleList()),
                        new Product(
                                historicScheme.getProduct().getCode(),
                                historicScheme.getProduct().getName(),
                                historicScheme.getProduct().getDescription(),
                                historicScheme.getProduct().getPrice(),
                                historicScheme.getProduct().getHeight(),
                                historicScheme.getProduct().getHeight(),
                                historicScheme.getProduct().getHeight(),
                        new Category(
                                historicScheme.getProduct().getCategory().getTYPE()
                        ),
                        historicScheme.getProduct().getStatus()
                ),
                historicScheme.getDate(),
                historicScheme.getDescription()
        );
    }

    public static HistoricScheme toHistoricScheme(Historic historic){
        return new HistoricScheme(
                historic.id(),
                new UserScheme(
                        historic.User().getCpf(),
                        historic.User().getFirstName(),
                        historic.User().getLastName(),
                        historic.User().getEmail(),
                        new AddressScheme(
                                historic.User().getAddress().zipCode(),
                                historic.User().getAddress().street(),
                                historic.User().getAddress().district(),
                                historic.User().getAddress().city(),
                                historic.User().getAddress().uf(),
                                historic.User().getAddress().ddd(),
                                historic.User().getAddress().complement()
                        ),
                        historic.User().getHouse(),
                        historic.User().getRoleList()),
                        new ProductScheme(
                                historic.product().getCode(),
                                historic.product().getName(),
                                historic.product().getDescription(),
                                historic.product().getPrice(),
                                historic.product().getWidth(),
                                historic.product().getHeight(),
                                historic.product().getWeight(),
                        new CategoryScheme(
                                historic.product().getCategory().type()
                        ),
                        historic.product().getStatus()
                ),
                historic.date(),
                historic.description()
        );
    }
}
