package com.psantana.mcc_customer_service.controller;

import com.psantana.mcc_customer_service.dto.CustomerDTO;
import com.psantana.mcc_customer_service.service.interfaces.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerRestController {

    private ICustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAll() {
        return customerService.findAll();
    }

    @GetMapping("/cu/{cu}")
    public CustomerDTO getByCu(@PathVariable("cu") String cu) {
        return customerService.findByCu(cu);
    }

    @GetMapping("/{id}")
    public CustomerDTO getById(@PathVariable("id") String id) {
        return customerService.findById(id);
    }

    @PostMapping
    public CustomerDTO add(@RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }

    @PutMapping
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO) {
        return customerService.update(customerDTO);
    }

    @DeleteMapping
    public void delete(@RequestBody CustomerDTO customerDTO) {
        customerService.delete(customerDTO);
    }

}
