package com.psantana.mcc_account_service.controller;

import com.psantana.mcc_account_service.dto.AccountDTO;
import com.psantana.mcc_account_service.dto.DepositDTO;
import com.psantana.mcc_account_service.service.interfaces.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountRestController {

    private IAccountService accountService;

    @GetMapping
    public List<AccountDTO> getAllAccounts() {
        return accountService.findAll();
    }

    @PostMapping
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.save(accountDTO);
    }

    @PutMapping
    public AccountDTO depositAccount(@RequestBody DepositDTO depositDTO) {
        return accountService.depositInAccount(depositDTO);
    }
}
