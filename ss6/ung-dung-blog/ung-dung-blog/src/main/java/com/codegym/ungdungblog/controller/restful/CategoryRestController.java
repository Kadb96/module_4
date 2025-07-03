package com.codegym.ungdungblog.controller.restful;

import com.codegym.ungdungblog.model.Category;
import com.codegym.ungdungblog.service.ICategoryService;
import com.codegym.ungdungblog.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<Category>> findAll() {
        List<Category> categories = (List<Category>) categoryService.findAll();
        if (categories == null || categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
