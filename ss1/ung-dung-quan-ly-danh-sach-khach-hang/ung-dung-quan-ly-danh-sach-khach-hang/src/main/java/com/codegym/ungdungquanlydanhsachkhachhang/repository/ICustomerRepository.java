package com.codegym.ungdungquanlydanhsachkhachhang.repository;

import com.codegym.ungdungquanlydanhsachkhachhang.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findById(long id);
    boolean save(Customer customer);
    boolean update(Customer customer);
    boolean delete(long id);
}
