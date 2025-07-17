package com.codegym.fooddeliversystem.service;

import com.codegym.fooddeliversystem.model.Restaurant;
import com.codegym.fooddeliversystem.model.User;

import java.util.Optional;

public interface IRestaurantService extends IGeneralService<Restaurant> {
    Optional<Restaurant> findByUser(String username);
}
