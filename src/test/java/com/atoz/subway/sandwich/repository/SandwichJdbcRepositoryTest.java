package com.atoz.subway.sandwich.repository;

import com.atoz.subway.sandwich.model.*;
import com.atoz.subway.topping.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
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
    @DisplayName("같은 샌드위치 인지 검사해주는 코드 테스트")
    void sandwichSameTest () {
        // Given
        LocalDateTime now = LocalDateTime.now();

        Long id = 4L;
        Bread bread = Bread.WHITE;
        Cheese cheese = Cheese.MOZZARELLA;
        Meat meat = Meat.BACON;
        Sauce sauce = Sauce.SWEET_CHILLI;
        Vegetable vegetable = Vegetable.LETTUCE;

        Long price = 15000L;
        OrderStatus orderStatus = OrderStatus.REJECTED;

        // When
        var p1 = new PulledPorkSandwich(1L, now);
        var p2 = new PulledPorkSandwich(1L, now);

        var e1 = new EggMayoSandwich(2L, now);
        var e2 = new EggMayoSandwich(2L, now);

        var c1 = new CustomSandwich(id, bread, cheese, meat, sauce, vegetable, price, orderStatus, now);
        var c2 = new CustomSandwich(id, bread, cheese, meat, sauce, vegetable, price, orderStatus, now);

        log.info("p1 : " + p1.toString());
        log.info("p2 : " + p2.toString());

        log.info("e1 : " + e1.toString());
        log.info("e2 : " + e2.toString());

        log.info("c1 : " + c1.toString());
        log.info("c2 : " + c2.toString());

        log.info("");

        // Then
        //assertThat(p1.isSame(p2)).isTrue();
        //assertThat(e1.isSame(e2)).isTrue();
        assertThat(c1.isSame(c2)).isTrue();
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

    @Test
    @DisplayName("찾기 테스트")
    void findByTest () {
        // Given
        var retrieved = repository.findAll();
        var ids = repository.getAllIds();

        // When
        List<Sandwich> sandwichList = new ArrayList<>();
        for(Long id :ids)
            sandwichList.add(repository.findById(id).get());

        // Then
        //for(int i = 0; i < sandwichList.size(); i++)
        //     assertThat(retrieved.get(i)).is(sandwichList.get(i));

    }



}
