package com.codegym.ungdungblog.controller;

import com.codegym.ungdungblog.model.Blog;
import com.codegym.ungdungblog.service.BlogService;
import com.codegym.ungdungblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        List<Blog> blogs = blogService.findAll();
        mv.addObject("blogs", blogs);
        return mv;
    }

    @GetMapping("/createForm")
    public ModelAndView showCreateForm() {
        ModelAndView mv = new ModelAndView("create");
        Blog blog = new Blog();
        mv.addObject("blog", blog);
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView mv = index();
        return mv;
    }

    @GetMapping("/{id}/editForm")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("edit");
        Blog blog = blogService.findById(id);
        mv.addObject("blog", blog);
        return mv;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView mv = index();
        return mv;
    }

    @GetMapping("/{id}/viewForm")
    public ModelAndView showViewForm(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("view");
        Blog blog = blogService.findById(id);
        mv.addObject("blog", blog);
        return mv;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        blogService.delete(id);
        ModelAndView mv = index();
        return mv;
    }
}
