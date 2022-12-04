package com.atoz.subway.sandwich.repository;

import com.atoz.subway.sandwich.model.OrderStatus;
import com.atoz.subway.sandwich.model.PulledPorkSandwich;
import com.atoz.subway.topping.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class SandwichJdbcRepositoryTest {
    @Autowired
    SandwichJdbcRepository repository;

    @Test
    void saveTest(){
        var sandwich = new PulledPorkSandwich(Bread.WHEAT, Cheese.AMERICAN, Meat.PULLED_PORK, Sauce.BARBEQUE, Vegetable.LETTUCE,
                15000, OrderStatus.COOKING, LocalDateTime.now());
        var retrieved = repository.save(sandwich);

        assertThat(sandwich).isEqualTo(retrieved);
    }

}
