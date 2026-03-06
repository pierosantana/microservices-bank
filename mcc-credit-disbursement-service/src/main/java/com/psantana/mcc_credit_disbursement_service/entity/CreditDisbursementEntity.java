package com.psantana.mcc_credit_disbursement_service.entity;

import com.psantana.mcc_credit_disbursement_service.dto.CreditDisbursementDTO;
import com.psantana.mcc_credit_disbursement_service.util.IMapper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "t_credit_disbursement")
@Data
@NoArgsConstructor
public class CreditDisbursementEntity implements IMapper<CreditDisbursementDTO>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false, length = 60)
    private String id;
    @Column(name = "amount", precision = 18, scale = 2)
    private BigDecimal amount;
    @Column(name = "term_months", nullable = false)
    private Integer termMonths;
    @Column(name = "interest_rate", precision = 10, scale = 2)
    private BigDecimal interestRate;
    @Column(name = "account_number", nullable = false, length = 13)
    private String accountNumber;
    @Column(name = "customer_cu", nullable = false, length = 20)
    private String customerCu;


    @Override
    public CreditDisbursementDTO getDTO() {
        return CreditDisbursementDTO.builder()
                .id(id)
                .amount(amount)
                .termMonths(termMonths)
                .interestRate(interestRate)
                .accountNumber(accountNumber)
                .customerCu(customerCu)
                .build();
    }

    @Override
    public void setData(CreditDisbursementDTO creditDisbursementDTO) {
        this.id = creditDisbursementDTO.getId();
        this.amount = creditDisbursementDTO.getAmount();
        this.termMonths = creditDisbursementDTO.getTermMonths();
        this.interestRate = creditDisbursementDTO.getInterestRate();
        this.accountNumber = creditDisbursementDTO.getAccountNumber();
        this.customerCu = creditDisbursementDTO.getCustomerCu();

    }
}
