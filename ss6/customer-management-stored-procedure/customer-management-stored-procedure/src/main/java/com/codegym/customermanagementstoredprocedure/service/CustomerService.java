package com.codegym.customermanagementstoredprocedure.service;

import com.codegym.customermanagementstoredprocedure.model.Customer;
import com.codegym.customermanagementstoredprocedure.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository icustomerRepository;

    @Override
    public boolean saveWithStoredProcedure(Customer customer) {
        return icustomerRepository.saveWithStoredProcedure(customer);
    }
}
