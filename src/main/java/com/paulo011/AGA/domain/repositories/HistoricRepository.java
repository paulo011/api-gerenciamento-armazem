package com.paulo011.AGA.domain.repositories;

import com.paulo011.AGA.domain.entities.Historic;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface HistoricRepository {
    void save(Historic historic);
    Historic findById(UUID id);
    List<Historic> findByUser(String cpf);
    List<Historic> findByProduct(UUID code);
    List<Historic> findByDate(Date date);
    List<Historic> findAll();
    void delete(UUID id);
}
