package com.atoz.subway.sandwich.service;

import com.atoz.subway.sandwich.model.Sandwich;

import java.util.List;
import java.util.Optional;

public abstract class SandwichService {
    public abstract Sandwich save(Sandwich sandwich);

    abstract Optional<Sandwich> findById(Long id);

    public abstract List<Sandwich> findAll();

    abstract Sandwich update(Sandwich sandwich);

    abstract long countAll();

    abstract void deleteAll();
}
