package com.codegym.ungdungblog.controller;

import com.codegym.ungdungblog.model.Category;
import com.codegym.ungdungblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("categories/index");
        Iterable<Category> categories = categoryService.findAll();
        mv.addObject("categories", categories);
        return mv;
    }

    @GetMapping("/createForm")
    public ModelAndView showCreateForm() {
        ModelAndView mv = new ModelAndView("categories/create");
        Category category = new Category();
        mv.addObject("category", category);
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView mv = index();
        return mv;
    }

    @GetMapping("/{id}/editForm")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView mv = new ModelAndView("categories/edit");
            mv.addObject("category", category.get());
            return mv;
        } else {
            return new ModelAndView("redirect:/categories");
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView mv = index();
        return mv;
    }

    @GetMapping("/{id}/viewForm")
    public ModelAndView showViewForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView mv = new ModelAndView("categories/view");
            mv.addObject("category", category.get());
            return mv;
        } else {
            return new ModelAndView("redirect:/categories");
        }
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        categoryService.delete(id);
        ModelAndView mv = index();
        return mv;
    }
}
