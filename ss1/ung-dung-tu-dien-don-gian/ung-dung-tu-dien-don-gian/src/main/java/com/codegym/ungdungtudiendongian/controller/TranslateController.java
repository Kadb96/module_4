package com.codegym.ungdungtudiendongian.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/translates")
public class TranslateController {
    @GetMapping("")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/results")
    public ModelAndView result(@RequestParam String vietnamese) {
        ModelAndView modelAndView = new ModelAndView("index");
        String english = "";
        if (vietnamese.equals("tao")) {
            english = "apple";
        } else if (vietnamese.equals("chuoi")) {
            english = "banana";
        } else if (vietnamese.equals("cam")) {
            english = "orange";
        } else if (vietnamese.equals("le")) {
            english = "pear";
        } else if (vietnamese.equals("nho")) {
            english = "grape";
        }
        modelAndView.addObject("vietnamese",vietnamese);
        modelAndView.addObject("english", english);
        return modelAndView;
    }
}
