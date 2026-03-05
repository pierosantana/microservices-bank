package com.psantana.mcc_account_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepositDTO {
    private String accountNumber;
    private String customerCu;
    private BigDecimal amount;
}
