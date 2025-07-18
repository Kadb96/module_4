package com.codegym.test.service.impl;

import com.codegym.test.model.ProductType;
import com.codegym.test.repository.IProductTypeRepository;
import com.codegym.test.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository productTypeRepository;

    @Override
    public Iterable<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public Optional<ProductType> findById(Long id) {
        return productTypeRepository.findById(id);
    }

    @Override
    public void save(ProductType productType) {

    }

    @Override
    public void delete(Long id) {

    }
}
