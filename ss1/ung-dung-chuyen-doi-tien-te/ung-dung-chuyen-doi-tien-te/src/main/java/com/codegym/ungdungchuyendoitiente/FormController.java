package com.codegym.ungdungchuyendoitiente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    @GetMapping("/forms")
    public ModelAndView forms(@RequestParam int vnd) {
        ModelAndView mv = new ModelAndView("form");
        mv.addObject("vnd", vnd);
        int usd = vnd / 21500;
        mv.addObject("usd", usd);
        return mv;
    }
}
