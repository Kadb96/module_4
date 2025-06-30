package com.codegym.springcountview.controller;

import com.codegym.springcountview.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("counter")
public class CounterController {
    @ModelAttribute
    public Counter setUpCounter(){
        return new Counter();
    }

    @GetMapping("/index")
    public ModelAndView get(@ModelAttribute("counter") Counter counter){
        ModelAndView mv = new ModelAndView("index");
        counter.increment();
        return mv;
    }
}
