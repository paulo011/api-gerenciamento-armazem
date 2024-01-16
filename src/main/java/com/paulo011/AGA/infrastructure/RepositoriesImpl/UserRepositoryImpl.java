package com.paulo011.AGA.infrastructure.RepositoriesImpl;

import com.paulo011.AGA.application.gateways.UserGateway;
import com.paulo011.AGA.domain.entities.User;
import com.paulo011.AGA.domain.repositories.UserRepository;
import com.paulo011.AGA.infrastructure.repositoriesJpa.UserRepositoryJpa;
import com.paulo011.AGA.infrastructure.schemes.UserScheme;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class UserRepositoryImpl implements UserRepository {
    private final UserRepositoryJpa userRepositoryInfra;

    public UserRepositoryImpl(UserRepositoryJpa userRepositoryInfra){
        this.userRepositoryInfra =userRepositoryInfra;
    }

    @Override
    public void save(User user) {
        UserScheme userSchema = UserGateway.toUserSchema(user);
        userRepositoryInfra.save(userSchema);
    }

    @Override
    public List<User> findAll() {
        List<UserScheme> userSchemeList = userRepositoryInfra.findAll();
        return userSchemeList.stream()
                .map(UserGateway::toUser).toList();
    }

    @Override
    public User findByCpf(String cpf) {
        Optional<UserScheme> userOption = userRepositoryInfra.findByCpf(cpf);
        if(userOption.isEmpty())
            throw new RuntimeException("user not found");
        return UserGateway.toUser(userOption.get());
    }

    @Override
    public void saveAndFlush(User user) {
        UserScheme userSchema = UserGateway.toUserSchema(user);
        userRepositoryInfra.saveAndFlush(userSchema);
    }
}
