package com.atoz.subway.sandwich.service;

import com.atoz.subway.sandwich.model.EggMayoSandwich;
import com.atoz.subway.sandwich.model.OrderStatus;
import com.atoz.subway.sandwich.model.PulledPorkSandwich;
import com.atoz.subway.topping.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class JdbcSandwichServiceTest {

    @Autowired
    JdbcSandwichService service;

    void addFiveSandwiches(String type){
        if(type.equals("pulled")){
            for(int i = 0; i < 5; i++)
                service.save(new PulledPorkSandwich(LocalDateTime.now()));
        }else if(type.equals("egg")){
            for(int i = 0; i < 5; i++)
                service.save(new EggMayoSandwich(LocalDateTime.now()));
        }
    }


    @Test
    @DisplayName("서비스 샌드위치 저장 테스트")
    void saveTest () {
        // Given
        addFiveSandwiches("pulled");

        // When


        // Then
        assertThat(service.countAll()).isGreaterThan(0L);
    }
}