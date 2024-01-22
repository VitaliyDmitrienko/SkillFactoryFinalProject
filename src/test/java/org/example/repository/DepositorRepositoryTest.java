package org.example.repository;

import org.example.entity.Depositor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepositorRepositoryTest {
    @Autowired
    private DepositorRepository depositorRepository;

    @Test
    void getData_whenGetAll_countIsThree () {
        List<Depositor> depositors = depositorRepository.findAll();
        Depositor depositorOne = depositors.get(1);
        System.out.println(depositors);
        System.out.println(depositorOne);
        Assertions.assertEquals(3, depositors.size());
    }

}