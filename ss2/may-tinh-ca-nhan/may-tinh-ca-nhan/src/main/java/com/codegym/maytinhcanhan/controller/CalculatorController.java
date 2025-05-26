package com.codegym.maytinhcanhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculators")
public class CalculatorController {
    @PostMapping("")
    public ModelAndView calculator(@RequestParam double firstNumber, @RequestParam double secondNumber,
                                   @RequestParam String formula) {
        ModelAndView mv = new ModelAndView("index");
        double result = 0;
        switch (formula) {
            case "addition":
                result = firstNumber + secondNumber;
                break;
            case "subtraction":
                result = firstNumber - secondNumber;
                break;
            case "multiplication":
                result = firstNumber * secondNumber;
                break;
            case "division":
                result = firstNumber / secondNumber;
        }
        String message = "Result " + formula + ": " + result;
        mv.addObject("message", message);
        return mv;
    }
}
