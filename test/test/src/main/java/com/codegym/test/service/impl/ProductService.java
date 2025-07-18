package com.codegym.test.service.impl;

import com.codegym.test.model.Product;
import com.codegym.test.repository.IProductRepository;
import com.codegym.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Product> findAllByNameContainingAndPriceGreaterThanEqual(String name, double price, Pageable pageable) {
        return productRepository.findAllByNameContainingAndPriceGreaterThanEqual(name, price, pageable);
    }

    @Override
    public Page<Product> findAllByNameContainingAndPriceGreaterThanEqualAndProductType(String name, double price, String productType, Pageable pageable) {
        return productRepository.findAllByNameContainingAndPriceGreaterThanEqualAndProductType(name, price, productType, pageable);
    }
}
