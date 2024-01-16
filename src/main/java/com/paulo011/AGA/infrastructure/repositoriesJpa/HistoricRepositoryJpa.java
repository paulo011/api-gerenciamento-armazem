package com.paulo011.AGA.infrastructure.repositoriesJpa;

import com.paulo011.AGA.infrastructure.schemes.HistoricScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface HistoricRepositoryJpa extends JpaRepository<HistoricScheme, UUID> {
    List<HistoricScheme> findByUserCpf(String cpf);
    List<HistoricScheme> findByProductCode(UUID code);
    List<HistoricScheme> findByDate(Date date);
}
