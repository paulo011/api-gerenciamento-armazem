package com.paulo011.AGA.infrastructure.schemes;

import com.paulo011.AGA.domain.constants.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class UserScheme {
    @Id
    @Column(name = "CPF", unique = true, updatable = false)
    private String cpf;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne()
    @JoinColumn(name = "ADDRESS_ID")
    private AddressScheme address;

    @Column(name = "HOUSE", length = 100)
    private String house;

    @Column(name = "ROLES", nullable = false)
    private List<Role> roleList;
}
