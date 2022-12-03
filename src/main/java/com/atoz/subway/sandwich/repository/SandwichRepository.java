package com.atoz.subway.sandwich.repository;

import com.atoz.subway.sandwich.model.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SandwichRepository extends JpaRepository<Sandwich, Long> {
    Sandwich save(Sandwich sandwich);
    Optional<Sandwich> findById(Long id);
    List<Sandwich> findAll();
    @Override
    long count();
}
