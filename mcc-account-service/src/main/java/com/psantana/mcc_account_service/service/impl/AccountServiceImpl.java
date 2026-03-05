package com.psantana.mcc_account_service.service.impl;

import com.psantana.mcc_account_service.client.ICustomerRestClient;
import com.psantana.mcc_account_service.dto.AccountDTO;
import com.psantana.mcc_account_service.dto.CustomerDTO;
import com.psantana.mcc_account_service.dto.DepositDTO;
import com.psantana.mcc_account_service.entity.AccountEntity;
import com.psantana.mcc_account_service.repository.IAccountRepository;
import com.psantana.mcc_account_service.service.interfaces.IAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private IAccountRepository accountRepository;
    private ICustomerRestClient customerRestClient;

    @Override
    public AccountDTO findById(String id) {
        return null;
    }

    @Override
    public List<AccountDTO> findAll() {
        log.info("Getting all accounts");
        return accountRepository.findAll().stream()
                .map(AccountEntity::getDTO)
                .toList();
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        ResponseEntity<CustomerDTO> responseNewCustomerDTO = customerRestClient.add(accountDTO.getCustomer());
        if (responseNewCustomerDTO.getStatusCode().is2xxSuccessful()) {
            log.info("Customer added successfully");
            accountDTO.setCustomer(responseNewCustomerDTO.getBody());
            log.info("accountDTO, {} ", accountDTO);
            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setData(accountDTO);
            log.info("Add entity to account Repository, {} ", accountEntity);
            return accountRepository.save(accountEntity).getDTO();
        }else{
            log.error("Customer not added successfully");
            return AccountDTO.builder().build();
        }

    }

    @Override
    public AccountDTO update(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO delete(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO depositInAccount(DepositDTO depositDTO) {
        log.info("Deposit into account repository, {} ", depositDTO);
        Optional<AccountEntity> accountEntityOptional = accountRepository.findByAccountNumberAndCustomerCu(depositDTO.getAccountNumber(), depositDTO.getCustomerCu());
        if (accountEntityOptional.isPresent()) {
            AccountEntity accountEntity = accountEntityOptional.get();
            accountEntity.setAccountBalance(accountEntity.getAccountBalance().add(depositDTO.getAmount()));
            return accountRepository.save(accountEntity).getDTO();
        }
        return AccountDTO.builder().build();
    }
}
