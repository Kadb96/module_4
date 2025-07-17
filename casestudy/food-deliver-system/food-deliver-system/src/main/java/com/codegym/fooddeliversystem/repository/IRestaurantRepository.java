package com.codegym.fooddeliversystem.repository;

import com.codegym.fooddeliversystem.model.Restaurant;
import com.codegym.fooddeliversystem.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IRestaurantRepository extends CrudRepository<Restaurant, Long> {
    Optional<Restaurant> findByRestaurantOwner_Id(Long restaurantOwnerId);

    Optional<Restaurant> findByRestaurantOwner_Username(String restaurantOwnerUsername);
}
