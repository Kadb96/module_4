package com.codegym.ungdungblog.service;

import com.codegym.ungdungblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Slice<Blog> findAllWithSlice(Pageable pageable);
    Slice<Blog> searchWithSlice(String name, Pageable pageable);
    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
    Page<Blog> findAllByNameContainingAndCategory(String name, String category, Pageable pageable);
    Page<Blog> findAllByCategory(String category, Pageable pageable);
    Iterable<Blog> findAllByCategory(String category);
}
