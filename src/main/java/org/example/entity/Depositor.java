package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
//@Builder
@AllArgsConstructor
@Table(name = "DEPOSITOR")
public class Depositor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    public Depositor(long l, int i) {
    }
}
