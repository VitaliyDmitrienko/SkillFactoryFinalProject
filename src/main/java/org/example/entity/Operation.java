package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "OPERATION")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "DEPOSITOR_ID")
    private Long depositor_id;

    @Column (name = "OPERATION_TYPE")
    private Long operation_type;

    @Column (name = "CHANGEBALANCE")
    private BigDecimal changebalance;

    @Column (name = "OPERATION_DATE")
    private Date operation_date;

}
