package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "OPERATION")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column (name = "DEPOSITORDONORID")
//    @OneToMany
    @ManyToOne
    @JoinColumn(name = "depositor_id", nullable = false)
//    private Long depositorDonorId;
    private Depositor depositorDonorId;

    @Column (name = "DEPOSITORACCEPTORID")
    private Long depositorAcceptorId;
//    @Column(insertable=false, updatable=false)
//    @ManyToOne
//    @JoinColumn(name = "depositor_id", nullable = false, insertable=false, updatable=false)
//    @JoinColumn(name = "depositor_id", nullable = false)
//    private Depositor depositorAcceptorId;

    @Column (name = "OPERATIONTYPE")
    private int operationType;

    @Column (name = "CHANGEBALANCE")
    private BigDecimal changeBalance;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "OPERATIONDATE")
    private LocalDateTime operationDate;

}
