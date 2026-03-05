package com.psantana.mcc_account_service.util;

public interface IMapper <T> {
    T getDTO();
    void setData(T t);
}
