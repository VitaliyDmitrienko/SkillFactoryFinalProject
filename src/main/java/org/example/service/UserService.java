package org.example.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.entity.Users;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
//@NoArgsConstructor(force = true)
//@RequiredArgsConstructor
public class UserService  {

    private final UserRepository userRepository;
    @Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public Optional<Users> getUser (long id) {
        return userRepository.findById(id);
    }

    public Users getBalance (long users_id) {
        return userRepository.findById(users_id).orElse(null);
    }

    public void putMoney (long user_id, BigDecimal income) {
        final var currentUser = userRepository.findById(user_id).orElseThrow();
        BigDecimal newBalance = currentUser.getBalance().add(income);
        currentUser.setBalance(newBalance);
        userRepository.save(currentUser);
    }

    public boolean takeMoney (long user_id, BigDecimal draw) {
        final var currentUser = userRepository.findById(user_id).orElseThrow();
        BigDecimal currentBalance = currentUser.getBalance();
        if (currentBalance.compareTo(draw) >=0 ) {
            BigDecimal newBalance = currentUser.getBalance().subtract(draw);
            currentUser.setBalance(newBalance);
            userRepository.save(currentUser);
            return true;
        } else return false;
    }

}
