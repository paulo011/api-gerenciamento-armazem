package com.paulo011.AGA.infrastructure.schemes;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "CATEGORY")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class CategoryScheme {
    @Id
    @Column(name = "TYPE", nullable = false, unique = true)
    private String TYPE;
}
