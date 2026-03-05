package com.psantana.mcc_credit_disbursement_service.util;

import java.util.List;

public interface ICrud <T> {
    T findById(String id);
    List<T> findAll();
    T save(T entity);
    T update(T entity);
    T delete(T entity);
}
