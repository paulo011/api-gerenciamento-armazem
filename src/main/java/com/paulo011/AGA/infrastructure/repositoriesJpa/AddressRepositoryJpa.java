package com.paulo011.AGA.infrastructure.repositoriesJpa;

import com.paulo011.AGA.infrastructure.schemes.AddressScheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepositoryJpa extends JpaRepository<AddressScheme, String> {
}
