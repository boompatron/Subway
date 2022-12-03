package com.atoz.subway.sandwich.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class SandwichRepositoryTest {
    @Autowired
    SandwichJpaRepository sandwichRepository;

    @Test
    void saveTest(){
        // var S = new PulledPorkSandwich()
        // var retrieved = sandwichRepository.save(new PulledPorkSandwich(1L, ))
    }

}
