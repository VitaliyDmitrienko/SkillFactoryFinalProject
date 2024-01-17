package org.example.service;

import org.example.entity.Depositor;
import org.example.exception.InsufficientBalanceException;
import org.example.exception.UserNotFoundException;
import org.example.exception.UserNotFoundException2;
import org.example.exception.WrongInputMoneyDataFormatException;
import org.example.repository.DepositorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
//@NoArgsConstructor(force = true)
//@RequiredArgsConstructor
public class DepositorService  {

    private final DepositorRepository depositorRepository;
    private final OperationService operationService;
    private final int putMoneyOperationType = 1;
    private final int takeMoneyOperationType = 2;
    @Autowired
    public DepositorService (DepositorRepository depositorRepository, OperationService operationService) {
        this.depositorRepository=depositorRepository;
        this.operationService = operationService;
    }

    public Depositor getUser (long depositor_id) {
        return depositorRepository.findById(depositor_id).
                orElseThrow(() -> new UserNotFoundException("User with ID=" + depositor_id + " not found / not exist."));
    }

    public Depositor getBalance (long depositor_id) {
            return depositorRepository.findById(depositor_id).
                    orElseThrow(() -> new UserNotFoundException("User with ID=" + depositor_id + " not found / not exist."));
    }

    @Transactional
    public void putMoney (long depositor_id, BigDecimal income) {
        if (income.compareTo(BigDecimal.valueOf(0)) <0) {
            methodWrongInputMoneyDataFormatException();
        }
        /*
        * add another version UserNotFoundException because of must return other error code response "0"
        * than standard "-1" according specifications for the project
        */
        final var currentUser = depositorRepository.findById(depositor_id).
                    orElseThrow(() -> new UserNotFoundException2("User with ID=" + depositor_id + " not found / not exist."));
        BigDecimal newBalance = currentUser.getBalance().add(income);
        currentUser.setBalance(newBalance);
        depositorRepository.save(currentUser);
//        methodException();
        operationService.storeOperation(currentUser.getId(), putMoneyOperationType, income);
        depositorRepository.findById(depositor_id);
    }

    @Transactional
    public void takeMoney (long depositor_id, BigDecimal withdraw) {
        if (withdraw.compareTo(BigDecimal.valueOf(0)) <0) {
            methodWrongInputMoneyDataFormatException();
        }
        /*
         * add another version UserNotFoundException because of must return other error code response "0"
         * than standard "-1" according specifications for the project
         */
        final var currentUser = depositorRepository.findById(depositor_id).
                orElseThrow(() -> new UserNotFoundException2("User with ID=" + depositor_id + " not found / not exist."));
        BigDecimal currentBalance = currentUser.getBalance();
        if (currentBalance.compareTo(withdraw) >=0 ) {
            BigDecimal newBalance = currentUser.getBalance().subtract(withdraw);
            currentUser.setBalance(newBalance);
            depositorRepository.save(currentUser);
            operationService.storeOperation(currentUser.getId(), takeMoneyOperationType, withdraw);
            getUser(depositor_id);
        } else throw new InsufficientBalanceException ("Operation: withdraw can't be execute." +
                " User with ID=" + depositor_id + " current balance lesser than request withdraw.");
    }

    void methodWrongInputMoneyDataFormatException() {
        throw new WrongInputMoneyDataFormatException("Wrong / unsupported input money data format. " +
                "Input value must be not sub zero.");
    }

}
