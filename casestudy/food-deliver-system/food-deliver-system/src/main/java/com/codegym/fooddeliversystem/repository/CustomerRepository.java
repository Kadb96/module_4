package com.codegym.fooddeliversystem.repository;

import com.codegym.fooddeliversystem.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
