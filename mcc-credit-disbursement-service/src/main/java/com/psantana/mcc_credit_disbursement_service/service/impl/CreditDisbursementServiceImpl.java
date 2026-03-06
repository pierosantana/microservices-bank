package com.psantana.mcc_credit_disbursement_service.service.impl;

import com.psantana.mcc_credit_disbursement_service.client.IAccountRestClient;
import com.psantana.mcc_credit_disbursement_service.dto.AccountDTO;
import com.psantana.mcc_credit_disbursement_service.dto.CreditDisbursementDTO;
import com.psantana.mcc_credit_disbursement_service.dto.DepositDTO;
import com.psantana.mcc_credit_disbursement_service.entity.CreditDisbursementEntity;
import com.psantana.mcc_credit_disbursement_service.repository.ICreditDisbursementRepository;
import com.psantana.mcc_credit_disbursement_service.service.interfaces.ICreditDisbursementService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class CreditDisbursementServiceImpl implements ICreditDisbursementService {

    private IAccountRestClient accountRestClient;
    private ICreditDisbursementRepository repository;


    @Override
    public CreditDisbursementDTO findById(String id) {
        return null;
    }

    @Override
    public List<CreditDisbursementDTO> findAll() {
        return repository.findAll().stream().map(CreditDisbursementEntity::getDTO).toList();
    }

    @Override
    public CreditDisbursementDTO save(CreditDisbursementDTO creditDisbursementDTO) {
        log.info("Add credit disbursement to repository, {}", creditDisbursementDTO );
        ResponseEntity<AccountDTO> responseEntityDepositInAccount = accountRestClient.depositInAccount(
                DepositDTO.builder()
                        .accountNumber(creditDisbursementDTO.getAccountNumber())
                        .amount(creditDisbursementDTO.getAmount())
                        .customerCu(creditDisbursementDTO.getCustomerCu())
                        .build()
        );
        if(responseEntityDepositInAccount.getStatusCode().is2xxSuccessful()) {
            CreditDisbursementEntity creditDisbursementEntity = new CreditDisbursementEntity();
            creditDisbursementEntity.setData(creditDisbursementDTO);
            return repository.save(creditDisbursementEntity).getDTO();

                }

        return CreditDisbursementDTO.builder().build();
    }

    @Override
    public CreditDisbursementDTO update(CreditDisbursementDTO entity) {
        return null;
    }

    @Override
    public CreditDisbursementDTO delete(CreditDisbursementDTO entity) {
        return null;
    }
}
