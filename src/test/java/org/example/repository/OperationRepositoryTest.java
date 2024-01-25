package org.example.repository;

import org.example.entity.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
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
        List<Operation> operationsAll = operationRepository.findAll();
        Assertions.assertEquals(17, operationsAll.size());
    }

    @Test
    void getOperationListZeroDepositorId () {
        List<Operation> operationsNull = operationRepository.findByDepositorDonorId(0L);
        Assertions.assertTrue(operationsNull.isEmpty());
    }

    @Test
    void getOperationListOverExistDepositorId () {
        List<Operation> operationsAll = operationRepository.findAll();
        List<Operation> operationsOver = operationRepository.findByDepositorDonorId(operationsAll.size()+1L);
        Assertions.assertTrue(operationsOver.isEmpty());
    }

    @Test
    void findByDepositorIdAndOperationDateBetween() {
        LocalDateTime beginDate = LocalDateTime.of(2024, 1, 20, 12, 0, 0, 0);
        LocalDateTime finishDate = LocalDateTime.of(2024, 1, 21, 12, 0, 0, 0);
        List<Operation> operationList = operationRepository.
                findByDepositorDonorIdAndOperationDateBetween(1, beginDate, finishDate);
        Assertions.assertEquals(9,operationList.size());
    }

 }