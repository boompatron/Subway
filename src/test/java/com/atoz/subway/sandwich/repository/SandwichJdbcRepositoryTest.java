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

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class SandwichJdbcRepositoryTest {
    @Autowired
    SandwichJdbcRepository repository;

    void addTenSandwiches(){
        for(int i = 0; i < 5; i++)
            repository.save(new PulledPorkSandwich(LocalDateTime.now()));
        for(int i = 0; i < 5; i++)
            repository.save(new EggMayoSandwich(LocalDateTime.now()));
    }

    // @BeforeAll
    void setUp(){
        addTenSandwiches();
    }

    // @AfterAll
    void cleanUp(){
        repository.deleteAll();
    }

    @Test
    @DisplayName("샌드위치 저장 테스트")
    void saveTest(){
        var sandwich = new PulledPorkSandwich(LocalDateTime.now());
        var retrieved = repository.save(sandwich);

        assertThat(sandwich).isEqualTo(retrieved);
    }

    @Test
    @DisplayName("모두 가져오기 테스트")
    void findAllTest(){
        var allSandwiches = repository.findAll();
        var size = repository.countAll();

        assertThat(allSandwiches.isEmpty()).isFalse();
        assertThat(allSandwiches.size()).isEqualTo(size).isEqualTo(10);
    }

    @Test
    @DisplayName("ids 만 가져오기 테스트")
    void getIdsTest(){
        var ids = repository.getAllIds();

        ids.forEach(System.out::println);
    }

    @Test
    @DisplayName("id로 찾기 테스트")
    void findByIdTest(){
        var ids = repository.getAllIds();

        var thirdSandwich = repository.findById(ids.get(3));
        var outOfBoundSandwich = repository.findById(Collections.max(ids) + 1);

        assertThat(thirdSandwich).isNotEmpty();
        assertThat(outOfBoundSandwich).isEmpty();
    }

    @Test
    @DisplayName("샌드위치 수정")
    void updateTest(){
        var id = repository.getAllIds().get(1);
        var name = repository.findById(id).get().getName();

        if(name.equals("Egg Mayo")){
            repository.update(new EggMayoSandwich(id, LocalDateTime.now()));
        }else{
            repository.update(new PulledPorkSandwich(id, LocalDateTime.now()));
        }

        var retrieved = repository.findById(id).get();

        assertThat(retrieved.getPrice()).isEqualTo(16000L);
        assertThat(retrieved.getOrderStatus()).isEqualTo(OrderStatus.DELAYED);

    }

}
