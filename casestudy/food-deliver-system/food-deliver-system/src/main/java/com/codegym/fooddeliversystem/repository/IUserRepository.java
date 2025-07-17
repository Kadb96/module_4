package com.codegym.fooddeliversystem.repository;

import com.codegym.fooddeliversystem.model.User;
import org.springframework.data.repository.CrudRepository;


public interface IUserRepository extends CrudRepository<User, Long> {
    User findUserByUsername(String username);
}
