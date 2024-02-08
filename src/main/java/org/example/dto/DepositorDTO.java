package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class DepositorDTO {
    private Long id;
    private BigDecimal balance;
}
