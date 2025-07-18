package com.codegym.test.repository;

import com.codegym.test.model.ProductType;
import org.springframework.data.repository.CrudRepository;

public interface IProductTypeRepository extends CrudRepository<ProductType, Long> {
}
