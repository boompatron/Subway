package com.atoz.subway.sandwich.repository;

import com.atoz.subway.sandwich.model.EggMayoSandwich;
import com.atoz.subway.sandwich.model.OrderStatus;
import com.atoz.subway.sandwich.model.PulledPorkSandwich;
import com.atoz.subway.topping.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class SandwichJdbcRepositoryTest {
    @Autowired
    SandwichJdbcRepository repository;

    @BeforeEach
    void setUp(){
        for(int i = 0; i < 5; i++)
            repository.save(new PulledPorkSandwich(LocalDateTime.now()));
        for(int i = 0; i < 5; i++)
            repository.save(new EggMayoSandwich(LocalDateTime.now()));
    }

    @AfterEach
    void cleanUp(){
        repository.deleteAll();
    }

    @Test
    @DisplayName("샌드위치 저장 테스트")
    void saveTest () {
        // Given

        // When
        var cnt = repository.countAll();
        var retrieved = repository.findAll();

        // Then
        assertThat(cnt).isEqualTo(10);
        assertThat(retrieved).isNotEmpty().hasSize(10);

    }




}
