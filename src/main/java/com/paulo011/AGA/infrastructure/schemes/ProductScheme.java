package com.paulo011.AGA.infrastructure.schemes;

import com.paulo011.AGA.domain.constants.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@Table(name = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ProductScheme {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CODE", updatable = false, unique = true)
    private UUID code;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "weight", nullable = false)
    private Float weight;

    @Column(name = "WIDTH", nullable = false)
    private Float width;

    @Column(name = "HEIGHT", nullable = false)
    private Float height;

    @OneToOne
    @JoinColumn(name = "CATEGORY")
    private CategoryScheme category;

    @Column(name = "STATUS")
    private Status status;
}
