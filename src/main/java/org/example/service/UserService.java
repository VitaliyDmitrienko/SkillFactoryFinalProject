package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Users;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserService (Users id) {
    private final UserRepository userRepository;

    public BigDecimal getBalance (Users id) {
        return userRepository.g
    }
}
