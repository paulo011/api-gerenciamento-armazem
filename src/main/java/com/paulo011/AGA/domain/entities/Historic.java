package com.paulo011.AGA.domain.entities;

import java.util.Date;
import java.util.UUID;

public record Historic(UUID id,
                       User User,
                       Product product,
                       Date date,
                       String description) {
}
