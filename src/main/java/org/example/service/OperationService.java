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

    public void storeOperation (Long depositor_donor_id, Long depositor_acceptor_id, int operation_type,
                                BigDecimal change_balance) {
//        depositor = depositorService.getUser(depositor_id);
        final var newOperation = new Operation();
//        newOperation.setDepositor_id(depositor.getId());
        newOperation.setDepositor_donor_id(depositor_donor_id);
        newOperation.setDepositor_acceptor_id(depositor_acceptor_id);
        newOperation.setOperation_type(operation_type);
        newOperation.setChange_balance(change_balance);
        newOperation.setOperation_date(java.time.LocalDateTime.now());
        operationRepository.save(newOperation);
    }

    public List<Operation> getOperationByDepositorId (long depositor_donor_id) {
        return operationRepository.findByDepositorDonorId(depositor_donor_id);
    }

    public List<Operation> getOperationByDepositorIdAndBetweenDates
            (long depositor_donor_id, LocalDateTime begin_date, LocalDateTime finish_date) {
//        if (begin_date.compareTo(null) <0  || finish_date.compareTo(null)<0) {
//            return getOperationByDepositorId(depositor_id);
//        } else
            return operationRepository.findByDepositorIdAndBetweenDates
                (depositor_donor_id, begin_date, finish_date);
    }
}
