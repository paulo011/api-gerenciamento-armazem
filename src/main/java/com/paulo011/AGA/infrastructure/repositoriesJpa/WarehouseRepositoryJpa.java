package com.paulo011.AGA.infrastructure.repositoriesJpa;

import com.paulo011.AGA.infrastructure.schemes.WarehouseScheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WarehouseRepositoryJpa extends JpaRepository<WarehouseScheme, UUID> {
}
