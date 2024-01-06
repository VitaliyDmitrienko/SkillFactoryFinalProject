package org.example.service;

import org.example.entity.Users;
import org.example.exception.InsufficientBalanceException;
import org.example.exception.UserNotFoundException;
import org.example.exception.UserNotFoundException2;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
//@NoArgsConstructor(force = true)
//@RequiredArgsConstructor
public class UserService  {

    private final UserRepository userRepository;
    @Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public Users getUser (long user_id) {
        return userRepository.findById(user_id).
                orElseThrow(() -> new UserNotFoundException("User with ID=" + user_id + " not found / not exist."));
    }

    public Users getBalance (long user_id) {
            return userRepository.findById(user_id).
                    orElseThrow(() -> new UserNotFoundException("User with ID=" + user_id + " not found / not exist."));
    }

    public void putMoney (long user_id, BigDecimal income) {
            final var currentUser = userRepository.findById(user_id).
                    orElseThrow(() -> new UserNotFoundException2("User with ID=" + user_id + " not found / not exist."));
            BigDecimal newBalance = currentUser.getBalance().add(income);
            currentUser.setBalance(newBalance);
            userRepository.save(currentUser);
            userRepository.findById(user_id);
    }


    public void takeMoney (long user_id, BigDecimal draw) {
        final var currentUser = userRepository.findById(user_id).
                orElseThrow(() -> new UserNotFoundException2("User with ID=" + user_id + " not found / not exist."));
        BigDecimal currentBalance = currentUser.getBalance();
        if (currentBalance.compareTo(draw) >=0 ) {
            BigDecimal newBalance = currentUser.getBalance().subtract(draw);
            currentUser.setBalance(newBalance);
            userRepository.save(currentUser);
            getUser(user_id);
        } else throw new InsufficientBalanceException("Operation: draw can't be execute." +
                " User with ID=" + user_id + " current balance lesser than draw.");
    }

}
