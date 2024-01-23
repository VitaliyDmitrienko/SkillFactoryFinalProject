package org.example.repository;

import org.example.entity.Depositor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@DataJpaTest
//@Sql(value = "classpath:init/user-data.sql", executionPhase = BEFORE_TEST_METHOD)
//@Sql(value = "classpath:data.sql", executionPhase = BEFORE_TEST_METHOD)
class DepositorRepositoryTest {
    @Autowired
    private DepositorRepository depositorRepository;

    @Test
    void getData_whenGetAll_countIsAll () {
        List<Depositor> depositors = depositorRepository.findAll();
//        Depositor depositorOne = depositors.get(1);
//        System.out.println(depositors);
//        System.out.println(depositorOne);
        Assertions.assertEquals(4, depositors.size());
    }

    @Test
    void getDepositorNullId () {
        Optional<Depositor> depositorNull = depositorRepository.findById(0L);
//        System.out.println(depositorNull);
//        Assertions.assertNull(depositorNull);
        Assertions.assertEquals(Optional.empty(),depositorNull);
    }

    @Test
    void getDepositorOverExistId () {
        List<Depositor> depositors = depositorRepository.findAll();
        Optional<Depositor> depositorOver = depositorRepository.findById(depositors.size()+1L);
        Assertions.assertEquals(Optional.empty(),depositorOver);
    }

}