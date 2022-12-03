package com.atoz.subway.sandwich.service;

import com.atoz.subway.sandwich.model.Sandwich;
import com.atoz.subway.sandwich.repository.SandwichRepository;
import com.atoz.subway.sandwich.validator.SandwichValidator;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JpaSandwichService extends SandwichService {

    private final SandwichRepository repository;

    private final SandwichValidator validator;


    public JpaSandwichService(SandwichRepository repository) {
        this.repository = repository;
        validator = new SandwichValidator();
    }

    @Override
    public Sandwich save(Sandwich sandwich){
        return repository.save(sandwich);
    }

    @Override
    public Sandwich findById(Long id){
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }
        throw new NullPointerException("No such sandwich");
    }

    @Override
    public long count(){
        return repository.count();
    }

    @Override
    public List<Sandwich> findAll() {
        return repository.findAll();
    }
}
