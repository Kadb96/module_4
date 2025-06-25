package com.codegym.validateinforuser.controller;

import com.codegym.validateinforuser.model.User;
import org.hibernate.id.BulkInsertionCapableIdentifierGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("user", new User());
        return mv;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("User") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("redirect:/user");
        }
        return new ModelAndView("/result");
    }
}
