package com.atoz.subway.sandwich.repository;

import com.atoz.subway.sandwich.model.Sandwich;

import java.util.List;

public interface SandwichRepository {
    Sandwich findById(Long id);
    List<Sandwich> findAll();
    void deleteAll();
    int count();
    Sandwich save(Sandwich sandwich);
}
