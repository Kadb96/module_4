package com.codegym.ungdungblog.controller;

import com.codegym.ungdungblog.model.Blog;
import com.codegym.ungdungblog.model.Category;
import com.codegym.ungdungblog.service.IBlogService;
import com.codegym.ungdungblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ModelAndView index(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView mv = new ModelAndView("blogs/index");
        Page<Blog> blogs = blogService.findAll(pageable);
        Iterable<Category> categories = categoryService.findAll();
        mv.addObject("blogs", blogs);
        mv.addObject("categories", categories);
        return mv;
    }

    @GetMapping("/search")
    public ModelAndView search(@PageableDefault(value = 5) Pageable pageable,
                               @RequestParam("search") Optional<String> search,
                               @RequestParam("categorySearch") Optional<String> categorySearch) {
        ModelAndView mv = new ModelAndView("blogs/index");
        Iterable<Category> categories = categoryService.findAll();
        Page<Blog> blogs;
        if (search.get().isEmpty() && categorySearch.get().equals("All Categories")) {
            blogs = blogService.findAll(pageable);
        } else if (search.get().isEmpty()) {
            blogs = blogService.findAllByCategory(categorySearch.get(), pageable);
        } else if (categorySearch.get().equals("All Categories")) {
            blogs = blogService.findAllByNameContaining(search.get(), pageable);
        } else {
            blogs = blogService.findAllByNameContainingAndCategory(search.get(), categorySearch.get(), pageable);
        }
        mv.addObject("blogs", blogs);
        mv.addObject("categories", categories);
        mv.addObject("search", search.get());
        mv.addObject("categorySearch", categorySearch.get());
        return mv;
    }

    @GetMapping("/createForm")
    public ModelAndView showCreateForm() {
        ModelAndView mv = new ModelAndView("blogs/create");
        Blog blog = new Blog();
        Iterable<Category> categories = categoryService.findAll();
        mv.addObject("blog", blog);
        mv.addObject("categories", categories);
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView mv = new ModelAndView("redirect:/blogs");
        return mv;
    }

    @GetMapping("/{id}/editForm")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        Iterable<Category> categories = categoryService.findAll();
        if (blog.isPresent()) {
            ModelAndView mv = new ModelAndView("blogs/edit");
            mv.addObject("blog", blog.get());
            mv.addObject("categories", categories);
            return mv;
        } else {
            return new ModelAndView("redirect:/blogs");
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView mv = new ModelAndView("redirect:/blogs");
        return mv;
    }

    @GetMapping("/{id}/viewForm")
    public ModelAndView showViewForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView mv = new ModelAndView("blogs/view");
            mv.addObject("blog", blog.get());
            return mv;
        } else {
            return new ModelAndView("redirect:/blogs");
        }
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        blogService.delete(id);
        ModelAndView mv = new ModelAndView("redirect:/blogs");
        return mv;
    }
}
