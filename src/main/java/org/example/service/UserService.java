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

    public Users getUser (long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public Optional<Users> getBalance (long user_id) {
//        if (getUser(user_id).equals(null)) { return Optional.empty();}
//        else {
            return userRepository.findById(user_id);
//        }
    }

    public Optional<Users> putMoney (long user_id, BigDecimal income) {
        try {
            final var currentUser = userRepository.findById(user_id).orElseThrow();
            BigDecimal newBalance = currentUser.getBalance().add(income);
            currentUser.setBalance(newBalance);
            userRepository.save(currentUser);
            return userRepository.findById(user_id);
        } catch (Exception e)  {
            return Optional.empty();
        }
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
