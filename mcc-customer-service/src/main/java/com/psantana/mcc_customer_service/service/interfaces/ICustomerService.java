package com.psantana.mcc_customer_service.service.interfaces;

import com.psantana.mcc_customer_service.dto.CustomerDTO;
import com.psantana.mcc_customer_service.util.ICrud;

public interface ICustomerService extends ICrud<CustomerDTO> {

    CustomerDTO findByCu(String cu);
}
