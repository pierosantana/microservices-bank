package com.psantana.mcc_customer_service.service.impl;

import com.psantana.mcc_customer_service.dto.CustomerDTO;
import com.psantana.mcc_customer_service.entity.CustomerEntity;
import com.psantana.mcc_customer_service.repository.ICustomerRepository;
import com.psantana.mcc_customer_service.service.interfaces.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerRepository customerRepository;

    @Override
    public CustomerDTO findByCu(String cu) {
        log.info("Get Customer by cu: {}", cu);
        Optional<CustomerEntity> customerEntity = customerRepository.findByCu(cu);
        if(customerEntity.isEmpty()) {
            return CustomerDTO.builder().build();
        }
        return customerEntity.get().getDTO();
    }

    @Override
    public CustomerDTO findById(String id) {
        log.info("Get Customer by ID: {}", id);
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        if(customerEntity.isEmpty()) {
            return CustomerDTO.builder().build();
        }
        return customerEntity.get().getDTO();
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(CustomerEntity::getDTO).toList();
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        log.info("Add customer {}", customerDTO);
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setData(customerDTO);
        return customerRepository.save(customerEntity).getDTO();
    }

    @Override
    public CustomerDTO update(CustomerDTO entity) {
        return null;
    }

    @Override
    public CustomerDTO delete(CustomerDTO entity) {
        return null;
    }
}
