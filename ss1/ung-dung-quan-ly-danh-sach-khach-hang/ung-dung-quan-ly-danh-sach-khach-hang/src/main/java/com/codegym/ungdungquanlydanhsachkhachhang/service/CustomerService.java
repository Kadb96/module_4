package com.codegym.ungdungquanlydanhsachkhachhang.service;

import com.codegym.ungdungquanlydanhsachkhachhang.model.Customer;
import com.codegym.ungdungquanlydanhsachkhachhang.repository.CustomerRepository;
import com.codegym.ungdungquanlydanhsachkhachhang.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }
}
