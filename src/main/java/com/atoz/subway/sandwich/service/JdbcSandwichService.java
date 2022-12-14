package com.atoz.subway.sandwich.service;

import com.atoz.subway.sandwich.model.Sandwich;
import com.atoz.subway.sandwich.repository.SandwichRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JdbcSandwichService extends SandwichService {
    private final SandwichRepository repository;

    public JdbcSandwichService(SandwichRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sandwich save(Sandwich sandwich) {
        return repository.save(sandwich);
    }

    @Override
    Optional<Sandwich> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Sandwich> findAll() {
        return repository.findAll();
    }

    @Override
    Sandwich update(Sandwich sandwich) {
        return repository.update(sandwich);
    }

    @Override
    long countAll() {
        return repository.countAll();
    }

    List<Long> getAllIds(){
        return repository.getAllIds();
    }

    @Override
    void deleteAll(){
        repository.deleteAll();
    }
}
