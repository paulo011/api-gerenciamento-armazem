package com.paulo011.AGA.infrastructure.schemes;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;
@Entity
@Table(name = "HISTORIC")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class HistoricScheme {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", unique = true, updatable = false)
    private UUID id;

    @ManyToOne
    private UserScheme user;

    @ManyToOne
    private ProductScheme product;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "DESCRIPTION")
    private String description;
}
