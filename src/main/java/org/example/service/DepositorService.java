package org.example.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.entity.Depositor;
import org.example.exception.InsufficientBalanceException;
import org.example.exception.UserNotFoundException;
import org.example.exception.UserNotFoundException2;
import org.example.repository.DepositorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Depositor getUser (long user_id) {
        return depositorRepository.findById(user_id).
                orElseThrow(() -> new UserNotFoundException("User with ID=" + user_id + " not found / not exist."));
    }

    public Depositor getBalance (long user_id) {
            return depositorRepository.findById(user_id).
                    orElseThrow(() -> new UserNotFoundException("User with ID=" + user_id + " not found / not exist."));
    }

    public void putMoney (long user_id, BigDecimal income) {
            final var currentUser = depositorRepository.findById(user_id).
                    orElseThrow(() -> new UserNotFoundException2("User with ID=" + user_id + " not found / not exist."));
            BigDecimal newBalance = currentUser.getBalance().add(income);
            currentUser.setBalance(newBalance);
            depositorRepository.save(currentUser);
            operationService.storeOperation(currentUser.getId(), putMoneyOperationType, income);
            depositorRepository.findById(user_id);
    }


    public void takeMoney (long user_id, BigDecimal draw) {
        final var currentUser = depositorRepository.findById(user_id).
                orElseThrow(() -> new UserNotFoundException2("User with ID=" + user_id + " not found / not exist."));
        BigDecimal currentBalance = currentUser.getBalance();
        if (currentBalance.compareTo(draw) >=0 ) {
            BigDecimal newBalance = currentUser.getBalance().subtract(draw);
            currentUser.setBalance(newBalance);
            depositorRepository.save(currentUser);
            getUser(user_id);
        } else throw new InsufficientBalanceException("Operation: draw can't be execute." +
                " User with ID=" + user_id + " current balance lesser than draw.");
    }

}
