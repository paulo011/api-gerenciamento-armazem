package com.paulo011.AGA.application.config;

import com.paulo011.AGA.application.webApplication.Clients.AddressClient;
import com.paulo011.AGA.infrastructure.RepositoriesImpl.*;
import com.paulo011.AGA.useCase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserUseCase userUseCase(UserRepositoryImpl userRepositoryImpl,
                                   AddressUseCase addressUseCase){
        return new UserUseCase(userRepositoryImpl, addressUseCase);
    }

    @Bean
    public ProductUseCase productUseCase(ProductRepositoryImpl productRepositoryImpl,
                                         CategoryUseCase categoryUseCase,
                                         HistoricUseCase historicUseCase){
        return new ProductUseCase(productRepositoryImpl, categoryUseCase, historicUseCase);
    }

    @Bean
    public CategoryUseCase categoryUseCase(CategoryRepositoryImpl categoryRepositoryImpl){
        return new CategoryUseCase(categoryRepositoryImpl);
    }

    @Bean
    public AddressUseCase addressUseCase(AddressClient addressClient,
                                         AddressRepositoryImpl addressRepositoryImpl){
        return new AddressUseCase(addressClient, addressRepositoryImpl);
    }

    @Bean
    public WarehouseUseCase WarehouseUseCase(WarehouseRepositoryImpl warehouseRepositoryImpl){
        return new WarehouseUseCase(warehouseRepositoryImpl);
    }

    @Bean
    public HistoricUseCase historicUseCase(HistoricRepositoryImpl historicRepositoryImpl,
                                           UserRepositoryImpl userRepositoryImpl){
        return new HistoricUseCase(historicRepositoryImpl, userRepositoryImpl);
    }

}
