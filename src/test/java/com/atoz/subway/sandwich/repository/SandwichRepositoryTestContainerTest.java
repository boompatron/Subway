package com.atoz.subway.sandwich.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

//package com.atoz.subway.sandwich.repository;
//
//
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.testcontainers.containers.MySQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.utility.DockerImageName;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//// @ActiveProfiles("test")
//// @SpringJUnitConfig
//// @SpringBootTest
//@Testcontainers
//class SandwichRepositoryTest {
//    @Container
//    private static MySQLContainer mysqlContainer = new MySQLContainer<>(DockerImageName.parse("mysql"))
//            .withDatabaseName("test_db")
//            .withUsername("root")
//            .withPassword("test1234!!");
//
//    @Test
//    @DisplayName("테스트 컨테이너 돌아가는지 테스트")
//    void testContainerTest(){
//        // assertThat(mysqlContainer.isRunning()).isTrue();
//        assertThat(1).isEqualTo(1);
//    }
//}


@Testcontainers
class SandwichRepositoryTestContainerTest {

    @Autowired
    private SandwichJpaRepository repository;

    @Container
    private static final MySQLContainer mysqlContainer = new MySQLContainer(DockerImageName.parse("mysql:latest"))
            .withDatabaseName("test_db")
            .withUsername("root")
            .withPassword("test1234!");

    @BeforeAll
    static void setup(){
        mysqlContainer.start();
    }

    @AfterAll
    static void cleanup(){
        mysqlContainer.stop();
    }

    @Test
    @DisplayName("컨테이너 돌아가는지 확인")
    void test() {
        assertThat(mysqlContainer.isRunning()).isTrue();
    }
    @Test
    @DisplayName("샌드위치 저장 테스트")
    void saveTest(){
    }
}
