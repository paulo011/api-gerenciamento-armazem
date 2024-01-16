package com.paulo011.AGA.infrastructure.schemes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "WAREHOUSE")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class WarehouseScheme {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", unique = true, updatable = false)
    private UUID id;

    @Column(name = "NAME", length = 100, unique = true)
    private String name;

    @OneToMany
    @JoinColumn(name = "WAREHOUSE_ID")
    private List<UserScheme> userList;

    @OneToMany
    @JoinColumn(name = "WAREHOUSE_ID")
    private List<ProductScheme> productList;
}
