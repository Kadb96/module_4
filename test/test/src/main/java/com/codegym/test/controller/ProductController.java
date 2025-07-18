package com.codegym.test.controller;

import com.codegym.test.model.Product;
import com.codegym.test.model.ProductType;
import com.codegym.test.service.IProductService;
import com.codegym.test.service.IProductTypeService;
import com.codegym.test.service.impl.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping("")
    public ModelAndView showList() {
        return new ModelAndView("redirect:/products/search");
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam("search") Optional<String> search,
                               @RequestParam("seachPrice") Optional<Double> searchPrice,
//                               @RequestParam("searchProductType") Optional<String> searchProductType,
                               @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        Page<Product> products;
        String searchKeyword;
//        String searchProductTypeKeyword;
        if (!search.isPresent()) {
            searchKeyword = "";
        } else {
            searchKeyword = search.get();
        }
//        double searchPriceKeyword;
//        if (!searchPrice.isPresent()) {
//            searchPriceKeyword = 0;
//        } else {
//            searchPriceKeyword = searchPrice.get();
//        }
        products = productService.findAllByNameContaining(searchKeyword, pageable);
        modelAndView.addObject("products", products);
        modelAndView.addObject("search", searchKeyword);
//        modelAndView.addObject("searchPrice", searchPriceKeyword);
        Iterable<ProductType> productTypes = productTypeService.findAll();
        modelAndView.addObject("productTypes", productTypes);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        Iterable<ProductType> productTypes = productTypeService.findAll();
        modelAndView.addObject("productTypes", productTypes);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditFrom(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Optional<Product> product = productService.findById(id);
        Iterable<ProductType> productTypes = productTypeService.findAll();
        modelAndView.addObject("product", product.get());
        modelAndView.addObject("productTypes", productTypes);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }
}