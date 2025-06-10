package com.codegym.ungdungquanlysanpham.repository;

import com.codegym.ungdungquanlysanpham.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(String id);
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(String id);
}
