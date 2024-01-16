package com.paulo011.AGA.infrastructure.repositoriesJpa;

import com.paulo011.AGA.infrastructure.schemes.UserScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepositoryJpa extends JpaRepository<UserScheme, String> {
    Optional<UserScheme> findByCpf(String cpf);
}