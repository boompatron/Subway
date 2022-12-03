package com.atoz.subway.sandwich.repository;

import com.atoz.subway.sandwich.model.Sandwich;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Primary
public class SandwichJdbcRepository implements SandwichRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public SandwichJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Sandwich save(Sandwich sandwich) {
        return null;
    }


    @Override
    public Sandwich findById(Long id) {
        return null;
    }

    @Override
    public List<Sandwich> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
