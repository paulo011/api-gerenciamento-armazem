package com.paulo011.AGA.infrastructure.RepositoriesImpl;

import com.paulo011.AGA.application.gateways.HistoricGateway;
import com.paulo011.AGA.domain.entities.Historic;
import com.paulo011.AGA.domain.repositories.HistoricRepository;
import com.paulo011.AGA.infrastructure.repositoriesJpa.HistoricRepositoryJpa;
import com.paulo011.AGA.infrastructure.schemes.HistoricScheme;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Transactional
public class HistoricRepositoryImpl implements HistoricRepository {
    private final HistoricRepositoryJpa historicRepositoryJpa;

    public HistoricRepositoryImpl(HistoricRepositoryJpa historicRepositoryJpa){
        this.historicRepositoryJpa = historicRepositoryJpa;
    }

    @Override
    public void save(Historic historic) {
        HistoricScheme historicScheme = HistoricGateway.toHistoricScheme(historic);
        historicRepositoryJpa.save(historicScheme);
    }

    @Override
    public Historic findById(UUID id) {
        Optional<HistoricScheme> historicSchemeOptional = historicRepositoryJpa.findById(id);
        if(historicSchemeOptional.isEmpty())
            throw new RuntimeException("historic not found");
        return HistoricGateway.toHistoric(historicSchemeOptional.get());
    }

    @Override
    public List<Historic> findByUser(String cpf) throws RuntimeException{
        List<HistoricScheme> historicUserSchemeList = historicRepositoryJpa.findByUserCpf(cpf);
        return historicUserSchemeList.stream()
                .map(HistoricGateway::toHistoric)
                .toList();
    }

    @Override
    public List<Historic> findByProduct(UUID code) throws RuntimeException {
        List<HistoricScheme> historicProductSchemeList = historicRepositoryJpa.findByProductCode(code);
        return historicProductSchemeList.stream()
                .map(HistoricGateway::toHistoric)
                .toList();
    }

    @Override
    public List<Historic> findByDate(Date date) {
        List<HistoricScheme> historicDateSchemeList = historicRepositoryJpa.findByDate(date);
        return historicDateSchemeList.stream()
                .map(HistoricGateway::toHistoric)
                .toList();
    }

    @Override
    public List<Historic> findAll() {
        List<HistoricScheme> historicSchemeList = historicRepositoryJpa.findAll();
        return historicSchemeList.stream()
                .map(HistoricGateway::toHistoric).toList();
    }

    @Override
    public void delete(UUID id) {
        historicRepositoryJpa.deleteById(id);
    }
}
