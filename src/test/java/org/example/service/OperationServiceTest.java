package org.example.service;

import org.example.repository.OperationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class OperationServiceTest {

    @Mock
    private OperationRepository operationRepository;

    @InjectMocks
    private OperationService operationService;



    @Test
    void storeOperation() {
    }

    @Test
    void getOperationByDepositorId() {
    }

    @Test
    void getOperationByDepositorIdAndOperationDateBetween() {
    }
}