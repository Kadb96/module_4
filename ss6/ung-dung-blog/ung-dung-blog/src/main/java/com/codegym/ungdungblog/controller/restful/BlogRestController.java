package com.codegym.ungdungblog.controller.restful;

import com.codegym.ungdungblog.model.Blog;
import com.codegym.ungdungblog.model.Category;
import com.codegym.ungdungblog.service.IBlogService;
import com.codegym.ungdungblog.service.ICategoryService;
import com.codegym.ungdungblog.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> findAll() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs == null || blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Iterable<Blog>> findByCategory(@PathVariable Long id, Pageable pageable) {
        Optional<Category> category = categoryService.findById(id);
        if (!category.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Blog> blogs = (List<Blog>) blogService.findAllByCategory(category.get().getName());
        if (blogs == null || blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
