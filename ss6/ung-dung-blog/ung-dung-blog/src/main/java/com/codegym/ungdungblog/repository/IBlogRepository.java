package com.codegym.ungdungblog.repository;

import com.codegym.ungdungblog.model.Blog;
import com.codegym.ungdungblog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByNameContaining(String name, Pageable pageable);

    Page<Blog> findAllByNameContainingAndCategory_Name(String name, String categoryName, Pageable pageable);

    Page<Blog> findAllByCategory_Name(String categoryName, Pageable pageable);
}
