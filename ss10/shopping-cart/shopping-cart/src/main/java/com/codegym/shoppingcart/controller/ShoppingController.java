package com.codegym.shoppingcart.controller;

import com.codegym.shoppingcart.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController {
    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/shopping_cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView mv = new ModelAndView("cart");
        mv.addObject("cart", cart);
        return mv;
    }
}
