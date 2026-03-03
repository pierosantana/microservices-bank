package com.psantana.mcc_customer_service.util;

import com.psantana.mcc_customer_service.dto.CustomerDTO;

public interface IMapper <T> {
    T getDTO();
    void setData(T t);
}
