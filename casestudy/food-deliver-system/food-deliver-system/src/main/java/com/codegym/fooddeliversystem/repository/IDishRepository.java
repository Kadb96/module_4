package com.codegym.fooddeliversystem.repository;

import com.codegym.fooddeliversystem.model.Dish;
import org.springframework.data.repository.CrudRepository;

public interface IDishRepository extends CrudRepository<Dish, Long> {
}
