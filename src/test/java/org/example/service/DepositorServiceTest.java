package org.example.service;

import org.aspectj.lang.annotation.Before;
import org.example.entity.Depositor;
import org.example.repository.DepositorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DepositorServiceTest {

    @Mock
    private DepositorRepository depositorRepository;

    @InjectMocks
    private DepositorService depositorService;
//    @Mock
//    private Depositor depositor;
//    private Depositor depositor2;
//    private Depositor depositor3;

    @BeforeEach
    public void setup(){
//        depositor1 = Depositor.builder().id(1L).balance(BigDecimal.valueOf(5000.00)).build();
//        depositor2 = Depositor.builder().id(2L).balance(BigDecimal.valueOf(10000.00)).build();

    }

    @Test
    void getDepositor() {
//        Depositor depositor1 = new Depositor(1L, 5000);
        Depositor depositor1 = Depositor.builder().id(1L).balance(BigDecimal.valueOf(5000.00)).build();

        Depositor depositor2 = new Depositor(2L, 10000);
//        Depositor depositor2 = Depositor.builder().id(1L).balance(BigDecimal.valueOf(5000.00)).build();
        Mockito.when(depositorRepository.findById(1L)).thenReturn(Optional.of(depositor1));

        Optional<Depositor> depositorTest = depositorRepository.findById(1L);
        System.out.println(depositorTest);
//        Long depositorId = depositorRepository.findById(1L).get().getId();
        Assertions.assertEquals(1L, depositorTest.get().getId());

    }

    @Test
    void getBalance() {
    }

    @Test
    void putMoney() {
    }

    @Test
    void takeMoney() {
    }

    @Test
    void transferMoney() {
    }
}