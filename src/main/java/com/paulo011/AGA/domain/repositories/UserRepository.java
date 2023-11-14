package com.paulo011.AGA.domain.repositories;

import com.paulo011.AGA.domain.entities.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    List<User> findAll();
    User findByCpf(String cpf);
    void saveAndFlush(User user);

}
