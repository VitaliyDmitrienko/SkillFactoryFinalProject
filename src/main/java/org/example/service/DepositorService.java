package org.example.service;

import org.example.dto.DepositorDTO;
import org.example.entity.*;
import org.example.exception.*;
//import org.example.exception.UserNotFoundException;
//import org.example.exception.UserNotFoundException2;
//import org.example.exception.WrongInputMoneyDataFormatException;
import org.example.mapper.DepositorMapper;
import org.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
//@NoArgsConstructor(force = true)
//@RequiredArgsConstructor
public class DepositorService  {
    @Autowired
    private DepositorRepository depositorRepository;
    @Autowired
    private final OperationService operationService;
    private final int putMoneyOperationType = 1;
    private final int takeMoneyOperationType = 2;
    private final int transferMoneyOperationType = 3;

    @Autowired
    private DepositorService (DepositorRepository depositorRepository, OperationService operationService) {
        this.depositorRepository=depositorRepository;
        this.operationService = operationService;
    }

    @Autowired
    private DepositorMapper depositorMapper;

//    public Depositor getDepositor (long id) {
//        return depositorRepository.findById(id).
//                orElseThrow(() -> new UserNotFoundException("User with ID=" + id + " not found / not exist."));
//    }

    public DepositorDTO getDepositor (long id) {
        var depositor = depositorRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException("User with ID=" + id + " not found / not exist."));
        var depositorDTO = depositorMapper.toDTO(depositor);
        return depositorDTO;
    }

    public Depositor getBalance (long depositor_id) {
            return depositorRepository.findById(depositor_id).
                    orElseThrow(() -> new UserNotFoundException("User with ID=" + depositor_id + " not found / not exist."));
    }

    @Transactional
    public void putMoney (long depositor_donor_id, BigDecimal income) {

        if (income.compareTo(BigDecimal.valueOf(0)) < 0) {
            methodWrongInputMoneyDataFormatException();
        }
        /*
        * add another version UserNotFoundException because of must return other error code response "0"
        * than standard "-1" according specifications for the project
        */
        final var currentUser = depositorRepository.findById(depositor_donor_id).
                    orElseThrow(() -> new UserNotFoundException2("User with ID=" + depositor_donor_id + " not found / not exist."));
        BigDecimal newBalance = currentUser.getBalance().add(income);
        currentUser.setBalance(newBalance);
        depositorRepository.save(currentUser);
//        methodException();
        operationService.storeOperation(currentUser.getId(), currentUser.getId(), putMoneyOperationType, income);
        depositorRepository.findById(depositor_donor_id);
    }

    @Transactional
    public void takeMoney (long depositor_id, BigDecimal withdraw) {
        if (withdraw.compareTo(BigDecimal.valueOf(0)) < 0) {
            methodWrongInputMoneyDataFormatException();
        }
        /*
         * add another version UserNotFoundException because of must return other error code response "0"
         * than standard "-1" according specifications for the project
         */
        final var currentDepositor = depositorRepository.findById(depositor_id).
                orElseThrow(() -> new UserNotFoundException2("User with ID=" + depositor_id + " not found / not exist."));
        BigDecimal currentBalance = currentDepositor.getBalance();
        if (currentBalance.compareTo(withdraw) >= 0 ) {
            BigDecimal newBalance = currentDepositor.getBalance().subtract(withdraw);
            currentDepositor.setBalance(newBalance);
            depositorRepository.save(currentDepositor);
            operationService.storeOperation(currentDepositor.getId(), currentDepositor.getId(), takeMoneyOperationType, withdraw);
            getDepositor(depositor_id);
        } else throw new InsufficientBalanceException ("Operation: withdraw can't be execute." +
                " User with ID=" + depositor_id + " current balance lesser than request withdraw.");
    }
    @Transactional
    public void transferMoney (long depositor_donor_id, long depositor_acceptor_id, BigDecimal transfer_balance) {
        if (transfer_balance.compareTo(BigDecimal.valueOf(0)) < 0) {
            methodWrongInputMoneyDataFormatException();
        }
        /*
         * add another version UserNotFoundException because of must return other error code response "0"
         * than standard "-1" according specifications for the project
         */
        final var donorDepositor = depositorRepository.findById(depositor_donor_id).
                orElseThrow(() -> new UserNotFoundException2("User with ID=" + depositor_donor_id + " not found / not exist."));
        final var acceptorDepositor = depositorRepository.findById(depositor_acceptor_id).
                orElseThrow(() -> new UserNotFoundException2("User with ID=" + depositor_acceptor_id + " not found / not exist."));
        BigDecimal donorBalance = donorDepositor.getBalance().subtract(transfer_balance);
        if (donorBalance.compareTo(transfer_balance) >= 0 ) {

            BigDecimal acceptorBalance = acceptorDepositor.getBalance().add(transfer_balance);
            donorDepositor.setBalance(donorBalance);
            acceptorDepositor.setBalance(acceptorBalance);
            depositorRepository.save(donorDepositor);
            depositorRepository.save(acceptorDepositor);
            operationService.storeOperation(donorDepositor.getId(), acceptorDepositor.getId(), transferMoneyOperationType, transfer_balance);
        } else throw new InsufficientBalanceException ("Operation: transfer money can't be execute." +
                " User with ID=" + depositor_donor_id + " current balance lesser than request transfer.");
    }

    void methodWrongInputMoneyDataFormatException() {
        throw new WrongInputMoneyDataFormatException("Wrong / unsupported input money data format. " +
                "Input value must be not sub zero.");
    }

}
