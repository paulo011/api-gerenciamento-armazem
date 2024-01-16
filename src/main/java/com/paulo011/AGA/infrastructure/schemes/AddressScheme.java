package com.paulo011.AGA.infrastructure.schemes;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ADDRESS")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class AddressScheme {
    @Id
    @Column(name = "ZIPCODE", nullable = false, unique = true, updatable = false)
    private String zipCode;

    @Column(name = "STREET", length = 100)
    private String street;

    @Column(name = "DISTRICT", length = 100)
    private String district;

    @Column(name = "CITY", length = 100)
    private String city;

    @Column(name = "UF", length = 2)
    private String uf;

    @Column(name = "DDD", length = 2)
    private Integer ddd;

    @Column(name = "complement", length = 100)
    private String complement;
}
