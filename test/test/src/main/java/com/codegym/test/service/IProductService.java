package com.codegym.test.service;

import com.codegym.test.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Page<Product> findAllByNameContainingAndPriceGreaterThanEqual(String name, double price, Pageable pageable);
    Page<Product> findAllByNameContainingAndPriceGreaterThanEqualAndProductType(String name, double price,String productType, Pageable pageable);
}
