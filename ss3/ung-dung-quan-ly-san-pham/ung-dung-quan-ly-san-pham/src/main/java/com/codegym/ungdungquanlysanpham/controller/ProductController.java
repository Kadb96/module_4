package com.codegym.ungdungquanlysanpham.controller;

import com.codegym.ungdungquanlysanpham.model.Product;
import com.codegym.ungdungquanlysanpham.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("index");
        List<Product> products = productService.findAll();
        mv.addObject("products", products);
        return mv;
    }

    @GetMapping("/addForm")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("add-form");
        mv.addObject("product", new Product());
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView mv = showAll();
        return mv;
    }

    @GetMapping("/editForm/{id}")
    public ModelAndView editForm(@PathVariable String id) {
        Product product = productService.findById(id);
        ModelAndView mv = new ModelAndView("edit-form");
        mv.addObject("product", product);
        return mv;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Product product) {
        productService.update(product);
        ModelAndView mv = showAll();
        return mv;
    }

    @GetMapping("/deleteForm/{id}")
    public ModelAndView deleteForm(@PathVariable String id) {
        Product product = productService.findById(id);
        ModelAndView mv = new ModelAndView("delete-form");
        mv.addObject("product", product);
        return mv;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute Product product) {
        String id = product.getId();
        productService.delete(id);
        ModelAndView mv = showAll();
        return mv;
    }

    @GetMapping("/viewForm/{id}")
    public ModelAndView viewForm(@PathVariable String id) {
        Product product = productService.findById(id);
        ModelAndView mv = new ModelAndView("view-form");
        mv.addObject("product", product);
        return mv;
    }
}
