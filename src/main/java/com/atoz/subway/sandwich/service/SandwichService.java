package com.atoz.subway.sandwich.service;

import com.atoz.subway.sandwich.model.Sandwich;

import java.util.List;
import java.util.Optional;

public abstract class SandwichService {
    abstract Sandwich save(Sandwich sandwich);

    abstract Optional<Sandwich> findById(Long id);

    abstract List<Sandwich> findAll();

    abstract Sandwich update(Sandwich sandwich);

    abstract long countAll();
}
