package com.paulo011.AGA.useCase;

import com.paulo011.AGA.domain.entities.Historic;
import com.paulo011.AGA.domain.entities.Product;
import com.paulo011.AGA.domain.entities.User;
import com.paulo011.AGA.domain.repositories.HistoricRepository;
import com.paulo011.AGA.domain.repositories.UserRepository;
import com.paulo011.AGA.useCase.DTO.HistoricResponseDTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class HistoricUseCase {
    private final HistoricRepository historicRepository;
    private final UserRepository userRepository;

    public HistoricUseCase(HistoricRepository historicRepository,
                           UserRepository userRepository){
        this.historicRepository = historicRepository;
        this.userRepository = userRepository;
    }

    public static List<HistoricResponseDTO> historicConverter(List<Historic> historicList){
        return historicList.stream()
                .map(HistoricResponseDTO::new)
                .toList();
    }

    public void createHistoric(String cpfUser, Product product,
                               String description){
        User user = userRepository.findByCpf(cpfUser);
        Historic historic = new Historic(
                null,
                user,
                product,
                new Date(),
                description);
        historicRepository.save(historic);
    }

    public List<HistoricResponseDTO> findAllHistoric(){
        List<Historic> historicList = historicRepository.findAll();
        return historicConverter(historicList);
    }

    public List<HistoricResponseDTO> findHistoricByUser(String cpf){
        List<Historic> historicList = historicRepository.findByUser(cpf);
        return historicConverter(historicList);
    }

    public List<HistoricResponseDTO> findHistoricByProduct(UUID code){
        List<Historic> historicList = historicRepository.findByProduct(code);
        return historicConverter(historicList);
    }

    public List<HistoricResponseDTO> findHistoricByDate(Date date){
        List<Historic> historicList = historicRepository.findByDate(date);
        return historicConverter(historicList);
    }
}
