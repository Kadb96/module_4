package com.codegym.jqueryeffect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EffectController {
    @GetMapping("/hide-button")
    public ModelAndView hideButton() {
        return new ModelAndView("hide-button");
    }

    @GetMapping("/animate-button")
    public ModelAndView animateButton() {
        return new ModelAndView("animate-button");
    }
}
