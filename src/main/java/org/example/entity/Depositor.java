package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
//@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
//@RequiredArgsConstructor
@Builder
@AllArgsConstructor
//@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Table(name = "DEPOSITOR")
public class Depositor {

//    private Depositor() {};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToMany
    @ManyToOne
    private Long id;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    public Depositor(long l, int i) {
    }
}
