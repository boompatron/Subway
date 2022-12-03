package com.atoz.subway.sandwich.service;

import com.atoz.subway.sandwich.model.Sandwich;
import com.atoz.subway.sandwich.repository.SandwichRepository;
import com.atoz.subway.sandwich.validator.SandwichValidator;

import java.util.List;

public abstract class SandwichService {

    // protected final SandwichRepository repository;

    abstract Sandwich save(Sandwich sandwich);

    abstract Sandwich findById(Long id);

    abstract List<Sandwich> findAll();

    abstract long count();
}
