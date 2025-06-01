package com.codegym.springformtutorial.service;

import com.codegym.springformtutorial.model.Employee;
import com.codegym.springformtutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean add(Employee employee) {
        return employeeRepository.add(employee);
    }
}
