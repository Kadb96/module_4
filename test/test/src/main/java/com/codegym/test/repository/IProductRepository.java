package com.codegym.test.repository;

import com.codegym.test.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);

    Page<Product> findAllByNameContainingAndPriceGreaterThanEqual(String name, double priceIsGreaterThan, Pageable pageable);

    Page<Product> findAllByNameContainingAndPriceGreaterThanEqualAndProductType(String name, double price, String productType, Pageable pageable);
}
