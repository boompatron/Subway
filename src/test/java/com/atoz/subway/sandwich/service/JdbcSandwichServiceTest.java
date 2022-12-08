package com.atoz.subway.sandwich.service;

import com.atoz.subway.sandwich.model.EggMayoSandwich;
import com.atoz.subway.sandwich.model.OrderStatus;
import com.atoz.subway.sandwich.model.PulledPorkSandwich;
import com.atoz.subway.topping.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class JdbcSandwichServiceTest {

    @Autowired
    JdbcSandwichService service;

    @BeforeEach
    void setUp(){
        for(int i = 0; i < 5; i++)
            service.save(new PulledPorkSandwich(LocalDateTime.now()));
        for(int i = 0; i < 5; i++)
            service.save(new EggMayoSandwich(LocalDateTime.now()));
    }

    @AfterEach
    void cleanUp(){
        service.deleteAll();
    }


    @Test
    @DisplayName("서비스 샌드위치 저장 테스트")
    void saveTest () {
        // Given

        // When
        var cnt = service.countAll();
        var retrieved = service.findAll();

        // Then
        assertThat(cnt).isEqualTo(10L);
        assertThat(retrieved).hasSize((int)cnt);
    }
}