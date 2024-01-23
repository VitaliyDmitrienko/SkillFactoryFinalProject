package org.example.repository;

import org.example.entity.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class OperationRepositoryTest {
    @Autowired
    private OperationRepository operationRepository;

    @Test
    void findListById() {
        List<Operation> operationListById = operationRepository.findById(1L);
        Assertions.assertEquals(10,operationListById.size());
    }


    @Test
    void getData_whenGetAll_countIsAll () {
        List<Operation> operation = operationRepository.findAll();
        Assertions.assertEquals(17, operation.size());
    }

    @Test
    void getOperationNullId () {
        List<Operation> operationNull = operationRepository.findById(0L);
        Assertions.assertNull(operationNull);
    }

    @Test
    void getDepositorOverExistId () {
        List<Operation> operations = operationRepository.findAll();
        List<Operation> operationOver = operationRepository.findById(operations.size()+1L);
        Assertions.assertNull(operationOver);
    }



    @Test
    void findByDepositorIdAndBetweenDates() {
    }

 }