package com.codegym.ungdungblog.service.impl;

import com.codegym.ungdungblog.model.Blog;
import com.codegym.ungdungblog.model.Category;
import com.codegym.ungdungblog.repository.IBlogRepository;
import com.codegym.ungdungblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Slice<Blog> findAllWithSlice(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Slice<Blog> searchWithSlice(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name, pageable);
    }


    @Override
    public Page<Blog> findAllByNameContaining(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Blog> findAllByNameContainingAndCategory(String name, String category, Pageable pageable) {
        return blogRepository.findAllByNameContainingAndCategory_Name(name, category, pageable);
    }

    @Override
    public Page<Blog> findAllByCategory(String category, Pageable pageable) {
        return blogRepository.findAllByCategory_Name(category, pageable);
    }

    @Override
    public Iterable<Blog> findAllByCategory(String category) {
        return blogRepository.findAllByCategory_Name(category);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
}
