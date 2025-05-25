package com.codegym.ungdungquanlydanhsachkhachhang.repository;

import com.codegym.ungdungquanlydanhsachkhachhang.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findById(long id);
    boolean updateCustomer(Customer customer);
}
