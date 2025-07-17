package com.codegym.fooddeliversystem.service.impl;

import com.codegym.fooddeliversystem.model.Restaurant;
import com.codegym.fooddeliversystem.model.User;
import com.codegym.fooddeliversystem.repository.IRestaurantRepository;
import com.codegym.fooddeliversystem.service.IRestaurantService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService implements IRestaurantService {
    private final IRestaurantRepository restaurantRepository;
    private final UserService userService;

    public RestaurantService(IRestaurantRepository restaurantRepository, UserService userService) {
        this.restaurantRepository = restaurantRepository;
        this.userService = userService;
    }

    @Override
    public Iterable<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void remove(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Optional<Restaurant> findByUser(String username) {
        return restaurantRepository.findByRestaurantOwner_Username(username);
    }
}
