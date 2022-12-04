package com.atoz.subway.sandwich.repository;

import com.atoz.subway.sandwich.model.Sandwich;

import java.util.List;
import java.util.Optional;

public interface SandwichRepository {
    Optional<Sandwich> findById(Long id);
    List<Sandwich> findAll();
    void deleteAll();
    int count();
    Sandwich save(Sandwich sandwich);
    Sandwich update(Sandwich sandwich);
}
