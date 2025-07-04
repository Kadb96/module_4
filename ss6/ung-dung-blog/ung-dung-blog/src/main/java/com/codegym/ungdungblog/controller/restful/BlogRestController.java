package com.codegym.ungdungblog.controller.restful;

import com.codegym.ungdungblog.model.Blog;
import com.codegym.ungdungblog.model.Category;
import com.codegym.ungdungblog.service.IBlogService;
import com.codegym.ungdungblog.service.ICategoryService;
import com.codegym.ungdungblog.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
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

    @GetMapping("/find_all_with_slice")
    public ResponseEntity<Slice<Blog>> findAllWithSlice(@PageableDefault(value = 3) Pageable pageable) {
        Slice<Blog> blogs = blogService.findAllWithSlice(pageable);
        if (blogs == null || blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/search_with_slice")
    public ResponseEntity<Slice<Blog>> searchWithSlice(@PageableDefault(value = 3) Pageable pageable,
                                                       @RequestParam(value = "searchName", required = false) String searchName) {
        Slice<Blog> blogs;
        if (searchName == null || searchName.isEmpty()) {
            blogs = blogService.findAllWithSlice(pageable);
        } else {
            blogs = blogService.findAllByNameContaining(searchName, pageable);
        }
        if (blogs == null || blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ResponseEntity<Slice<Blog>> response = new ResponseEntity<>(blogs, HttpStatus.OK);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }
}
