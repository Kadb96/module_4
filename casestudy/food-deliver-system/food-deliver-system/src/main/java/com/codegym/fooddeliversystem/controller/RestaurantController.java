package com.codegym.fooddeliversystem.controller;

import com.codegym.fooddeliversystem.model.Dish;
import com.codegym.fooddeliversystem.model.Restaurant;
import com.codegym.fooddeliversystem.model.User;
import com.codegym.fooddeliversystem.service.IDishService;
import com.codegym.fooddeliversystem.service.IRestaurantService;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owners/restaurants")
public class RestaurantController {
    @Autowired
    private IDishService dishService;

    @Autowired
    private IRestaurantService restaurantService;

    @GetMapping("")
    public ModelAndView showAllDish(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("userSession");
        Restaurant restaurant = restaurantService.findByUser(user.getUsername()).orElse(null);
        if (restaurant != null) {
            ModelAndView mv = new ModelAndView("owners/restaurant");
            Iterable<Dish> dishes = dishService.findAll();
            mv.addObject("dishes", dishes);
            return mv;
        }
        ModelAndView mv = new ModelAndView("redirect:/owners/restaurants/create_restaurant_form");
        return mv;
    }

    @GetMapping("/create_restaurant_form")
    public ModelAndView createRestaurantForm() {
        ModelAndView mv = new ModelAndView("owners/create_restaurant_form");
        Restaurant restaurant = new Restaurant();
        mv.addObject("restaurant", restaurant);
        return mv;
    }

    @PostMapping("/create_restaurant")
    public ModelAndView createRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("userSession");
        restaurant.setRestaurantOwner(user);
        restaurantService.save(restaurant);
        return new ModelAndView("redirect:/owners/restaurants");
    }

    @GetMapping("/add_dish_form")
    public ModelAndView addDishForm(HttpSession httpSession) {
        ModelAndView mv = new ModelAndView("owners/add_dish_form");
        Dish dish = new Dish();
        mv.addObject("dish", dish);
        return mv;
    }

    @PostMapping("/add_dish")
    public ModelAndView addDish(@ModelAttribute Dish dish, HttpSession httpSession) {
        ModelAndView mv = new ModelAndView("redirect:/owners/restaurants");
        User user = (User) httpSession.getAttribute("userSession");
        Restaurant restaurant = restaurantService.findByUser(user.getUsername()).get();
        dish.setRestaurant(restaurant);
        dishService.save(dish);
        return mv;
    }

    @GetMapping("/delete_dish/{id}")
    public ModelAndView deleteDish(@PathVariable("id") Long Id) {
        ModelAndView mv = new ModelAndView("redirect:/owners/restaurants");
        dishService.remove(Id);
        return mv;
    }

    @GetMapping("/dish_detail/{id}")
    public ModelAndView showDish(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("owners/show_dish_form");
        Dish dish = dishService.findById(id).orElse(null);
        if (dish != null) {
            mv.addObject("dish", dish);
        } else {
            mv.addObject("error", "Dish not found");
        }
        return mv;
    }

    @GetMapping("/edit_dish_form/{id}")
    public ModelAndView editDishForm(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("owners/edit_dish_form");
        Dish dish = dishService.findById(id).orElse(null);
        if (dish != null) {
            mv.addObject("dish", dish);
        } else {
            mv.addObject("error", "Dish not found");
        }
        return mv;
    }

    @PostMapping("/edit_dish")
    public ModelAndView editDish(@ModelAttribute Dish dish, HttpSession httpSession) {
        ModelAndView mv = new ModelAndView("redirect:/owners/restaurants");
        User user = (User) httpSession.getAttribute("userSession");
        Restaurant restaurant = restaurantService.findByUser(user.getUsername()).get();
        dish.setRestaurant(restaurant);
        dishService.save(dish);
        return mv;
    }
}
