package org.example.service;

import org.example.entity.Depositor;
import org.example.entity.Operation;
import org.example.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;

@Service
public class OperationService {
    private final OperationRepository operationRepository;
    private final DepositorService depositorService;
    private Depositor depositor;

    @Autowired
    public OperationService (OperationRepository operationRepository, DepositorService depositorService) {
        this.operationRepository = operationRepository;
        this.depositorService = depositorService;
    }

    public void storeOperation (Long depositor_id, int operation_type,
                                BigDecimal changeBalance) {
        depositor = depositorService.getUser(depositor_id);
        final var newOperation = new Operation();
        newOperation.setDepositor_id(depositor.getId());
        newOperation.setOperation_type(operation_type);
        newOperation.setChangeBalance(changeBalance);
        newOperation.setOperation_date(java.time.LocalDateTime.now());
        operationRepository.save(newOperation);

    }
}
