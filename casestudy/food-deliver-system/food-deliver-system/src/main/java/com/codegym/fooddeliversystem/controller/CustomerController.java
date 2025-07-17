package com.codegym.fooddeliversystem.controller;

import com.codegym.fooddeliversystem.model.Dish;
import com.codegym.fooddeliversystem.model.Restaurant;
import com.codegym.fooddeliversystem.model.User;
import com.codegym.fooddeliversystem.service.IDishService;
import com.codegym.fooddeliversystem.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping("/customers")
//@SessionAttributes("cart")
public class CustomerController {
    @Autowired
    private IRestaurantService restaurantService;

    @Autowired
    private IDishService dishService;

//    @ModelAttribute("cart")
//    public HashMap<Dish, Integer> setUpCart() {
//        return new HashMap<Dish, Integer>();
//    }

    @GetMapping("")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("customers/index");
        Iterable<Restaurant> restaurants = restaurantService.findAll();
        Iterable<Dish> dishes = dishService.findAll();
        mv.addObject("restaurants", restaurants);
        mv.addObject("dishes", dishes);
        return mv;
    }

    @GetMapping("/add_to_cart/{id}")
    public ModelAndView addToCart(@ModelAttribute("cart")HashMap<Dish, Integer> cart, @PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("redirect:/customers");
        Dish dish = dishService.findById(id).orElse(null);
        cart.put(dish, cart.getOrDefault(dish, 0) + 1);
        return mv;
    }

    @GetMapping("/show_cart")
    public ModelAndView showCart() {
        ModelAndView mv = new ModelAndView("customers/cart");
        return mv;
    }
}
