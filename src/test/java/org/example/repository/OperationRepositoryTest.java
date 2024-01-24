package org.example.repository;

import org.example.entity.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
class OperationRepositoryTest {
    @Autowired
    private OperationRepository operationRepository;

    @Test
    void findOperationById() {
        Operation operationById = operationRepository.findById(1);
        Assertions.assertEquals(1,operationById.getId());
    }


    @Test
    void getData_whenGetAll_countIsAll () {
        List<Operation> operation = operationRepository.findAll();
        Assertions.assertEquals(17, operation.size());
    }

    @Test
    void getOperationNullId () {
        List<Operation> operationNull = operationRepository.findByDepositorDonorId(0L);
        Assertions.assertNull(operationNull);
    }

    @Test
    void getDepositorOverExistId () {
        List<Operation> operations = operationRepository.findAll();
        List<Operation> operationOver = operationRepository.findByDepositorDonorId(operations.size()+1L);
        Assertions.assertNull(operationOver);
    }



    @Test
    void findByDepositorIdAndBetweenDates() {
    }

 }