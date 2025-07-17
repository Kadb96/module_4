package com.codegym.fooddeliversystem.service.impl;

import com.codegym.fooddeliversystem.model.Dish;
import com.codegym.fooddeliversystem.repository.IDishRepository;
import com.codegym.fooddeliversystem.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DishService implements IDishService {
    @Autowired
    private IDishRepository dishRepository;

    @Override
    public Iterable<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);
    }

    @Override
    public void save(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public void remove(Long id) {
        dishRepository.deleteById(id);
    }
}
