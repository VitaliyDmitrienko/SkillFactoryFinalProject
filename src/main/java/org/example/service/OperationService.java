package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Depositor;
import org.example.entity.Operation;
import org.example.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
public class OperationService {
    private final OperationRepository operationRepository;
//    private DepositorService depositorService;
    private Depositor depositor;

    @Autowired
    public OperationService (OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public void storeOperation (Long depositorDonorId, Long depositorAcceptorId, int operationType,
                                BigDecimal changeBalance) {
//        depositor = depositorService.getUser(depositor_id);
        final var newOperation = new Operation();
//        newOperation.setDepositor_id(depositor.getId());
        newOperation.setDepositorDonorId(depositorDonorId);
        newOperation.setDepositorAcceptorId(depositorAcceptorId);
        newOperation.setOperationType(operationType);
        newOperation.setChangeBalance(changeBalance);
        newOperation.setOperationDate(java.time.LocalDateTime.now());
        operationRepository.save(newOperation);
    }

    public List<Operation> getOperationByDepositorId (long depositorDonorId) {
        return operationRepository.findByDepositorDonorId(depositorDonorId);
    }

    public List<Operation> getOperationByDepositorIdAndBetweenDates
            (long depositorDonorId, LocalDateTime beginDate, LocalDateTime finishDate) {
//        if (beginDate.compareTo(null) <0  || finish_date.compareTo(null)<0) {
//            return getOperationByDepositorId(depositor_id);
//        } else
            return operationRepository.findByDepositorIdAndBetweenDates
                (depositorDonorId, beginDate, finishDate);
    }
}
