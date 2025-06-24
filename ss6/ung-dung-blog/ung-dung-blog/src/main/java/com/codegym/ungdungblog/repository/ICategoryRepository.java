package com.codegym.ungdungblog.repository;

import com.codegym.ungdungblog.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
}
