package com.codegym.shoppingcart.controller;

import com.codegym.shoppingcart.model.Cart;
import com.codegym.shoppingcart.model.Product;
import com.codegym.shoppingcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute
    public Cart getCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView mv = new ModelAndView("shop");
        mv.addObject("products", productService.findAll());
        return mv;
    }

    @GetMapping("/add/{id}")
    public ModelAndView addToCart(@PathVariable Long id, @ModelAttribute Cart cart,
                                  @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ModelAndView("error");
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return new ModelAndView("redirect:/shopping_cart");
        }
        cart.addProduct(productOptional.get());
        return new ModelAndView("redirect:/shop");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView removeFromCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        cart.removeProduct(productOptional.get());
        return new ModelAndView("redirect:/shopping_cart");
    }

    @GetMapping("view/{id}")
    public ModelAndView viewCart(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ModelAndView("error");
        }
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("product", productOptional.get());
        return mv;
    }

    @GetMapping("buy")
    public ModelAndView buyCart(@ModelAttribute Cart cart) {
        cart = new Cart();
        ModelAndView mv = new ModelAndView("redirect:/shop");
        return mv;
    }
}
