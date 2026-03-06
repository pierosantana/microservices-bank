package com.psantana.mcc_credit_disbursement_service.controller;

import com.psantana.mcc_credit_disbursement_service.dto.CreditDisbursementDTO;
import com.psantana.mcc_credit_disbursement_service.service.interfaces.ICreditDisbursementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class CreditDisbursementRestController {

    private ICreditDisbursementService creditDisbursementService;

    @GetMapping
    public List<CreditDisbursementDTO> getAllCreditDisbursements(){
        return creditDisbursementService.findAll();
    }

    @PostMapping
    public CreditDisbursementDTO addCreditDisbursement(@RequestBody CreditDisbursementDTO dto){
        return creditDisbursementService.save(dto);
    }

}
