package org.example.service;

import org.example.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;

@Service
public class OperationService {
    private final OperationRepository operationRepository;
    @Autowired
    public OperationService (OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public void storeOperation (Long id, Long depositor_id, int operation_type,
                                BigDecimal changeBalance, Date timestamp) {

    }
}
