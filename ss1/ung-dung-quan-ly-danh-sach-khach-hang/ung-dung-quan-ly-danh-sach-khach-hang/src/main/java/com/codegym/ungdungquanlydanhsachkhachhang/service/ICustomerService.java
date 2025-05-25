package com.codegym.ungdungquanlydanhsachkhachhang.service;

import com.codegym.ungdungquanlydanhsachkhachhang.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(long id);
    boolean updateCustomer(Customer customer);

}
