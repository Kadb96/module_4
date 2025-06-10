package com.codegym.ungdungquanlysanpham.service;

import com.codegym.ungdungquanlysanpham.model.Product;
import com.codegym.ungdungquanlysanpham.repository.IProductRepository;
import com.codegym.ungdungquanlysanpham.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean delete(String id) {
        return productRepository.delete(id);
    }
}
