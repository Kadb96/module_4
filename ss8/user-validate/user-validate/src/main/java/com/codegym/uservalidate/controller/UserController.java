package com.codegym.uservalidate.controller;

import com.codegym.uservalidate.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    @GetMapping("")
    public ModelAndView form() {
        ModelAndView mv = new ModelAndView("form");
        mv.addObject("user", new User());
        return mv;
    }

    @PostMapping("/result")
    public ModelAndView result(@Valid @ModelAttribute("user") User user, BindingResult result) {
        new User().validate(user, result);
        if (result.hasFieldErrors()) {
            return new ModelAndView("redirect:/users");
        }
        ModelAndView mv = new ModelAndView("result");
        mv.addObject("user", user);
        return mv;
    }
}
