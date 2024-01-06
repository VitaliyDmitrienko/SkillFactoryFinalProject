package org.example.service;

import org.example.entity.Users;
import org.example.exception.UserNotFoundException;
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

    public Users getUser (long user_id) {
        return userRepository.findById(user_id).
                orElseThrow(() -> new UserNotFoundException("User with id " + user_id + " not found / not exist."));
    }

    public Users getBalance (long user_id) {
            return getUser(user_id);
    }

    public Optional<Users> putMoney (long user_id, BigDecimal income) {
//        try {
            final var currentUser = getUser(user_id);
            BigDecimal newBalance = currentUser.getBalance().add(income);
            currentUser.setBalance(newBalance);
            userRepository.save(currentUser);
            return userRepository.findById(user_id);
//        } catch (Exception e)  {
//            return Optional.empty();
        }


    public Users takeMoney (long user_id, BigDecimal draw) {
        final var currentUser = getUser(user_id);
        BigDecimal currentBalance = currentUser.getBalance();
        if (currentBalance.compareTo(draw) >=0 ) {
            BigDecimal newBalance = currentUser.getBalance().subtract(draw);
            currentUser.setBalance(newBalance);
            userRepository.save(currentUser);
            return getUser(user_id);
        } else return new Users();
    }

}
