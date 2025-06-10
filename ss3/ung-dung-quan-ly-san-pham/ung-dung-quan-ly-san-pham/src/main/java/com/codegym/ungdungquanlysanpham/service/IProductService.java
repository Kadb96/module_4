package com.codegym.ungdungquanlysanpham.service;

import com.codegym.ungdungquanlysanpham.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(String id);
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(String id);
}
