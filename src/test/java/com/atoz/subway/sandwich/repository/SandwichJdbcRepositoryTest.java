package com.atoz.subway.sandwich.repository;

import com.atoz.subway.sandwich.model.EggMayoSandwich;
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
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.COLLECTION;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class SandwichJdbcRepositoryTest {
    @Autowired
    SandwichJdbcRepository repository;

    void addTenSandwiches(){
        for(int i = 0; i < 5; i++)
            repository.save(new PulledPorkSandwich(Bread.WHEAT, Cheese.AMERICAN, Meat.PULLED_PORK, Sauce.BARBEQUE, Vegetable.LETTUCE,
                    i * 1000, OrderStatus.COOKING, LocalDateTime.now()));
        for(int i = 0; i < 5; i++)
            repository.save(new EggMayoSandwich(Bread.FLAT_BREAD, Cheese.MOZZARELLA, Meat.BACON, Sauce.MAYONNAISE, Vegetable.TOMATO,
                    i * 1000, OrderStatus.COOKING, LocalDateTime.now()));
    }

    @BeforeAll
    void setUp(){
        addTenSandwiches();
    }

    @AfterAll
    void cleanUp(){
        repository.deleteAll();
    }

    @Test
    @DisplayName("샌드위치 저장 테스트")
    void saveTest(){
        var sandwich = new PulledPorkSandwich(Bread.WHEAT, Cheese.AMERICAN, Meat.PULLED_PORK, Sauce.BARBEQUE, Vegetable.LETTUCE,
                15000, OrderStatus.COOKING, LocalDateTime.now());
        var retrieved = repository.save(sandwich);

        assertThat(sandwich).isEqualTo(retrieved);
    }

    @Test
    @DisplayName("모두 가져오기 테스트")
    void findAllTest(){
        var allSandwiches = repository.findAll();

        assertThat(allSandwiches.isEmpty()).isFalse();
        assertThat(allSandwiches.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("ids만 가져오기 테스트")
    void getIdsTest(){
        var ids = repository.getIds();

        ids.forEach(System.out::println);
    }

    @Test
    @DisplayName("id로 찾기 테스트")
    void findByIdTest(){
        var ids = repository.getIds();

        var thirdSandwich = repository.findById(ids.get(3));
        var outOfBoundSandwich = repository.findById(Collections.max(ids) + 1);

        assertThat(thirdSandwich).isNotEmpty();
        assertThat(outOfBoundSandwich).isEmpty();
    }



}
