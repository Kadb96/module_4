package com.codegym.ungdungquanlydanhsachkhachhang.service;

import com.codegym.ungdungquanlydanhsachkhachhang.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(long id);
    boolean save(Customer customer);
    boolean update(Customer customer);
    boolean delete(long id);

}
