package com.codegym.customermanagementstoredprocedure.controller;

import com.codegym.customermanagementstoredprocedure.model.Customer;
import com.codegym.customermanagementstoredprocedure.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/createForm")
    public ModelAndView createForm() {
        ModelAndView mv = new ModelAndView("create");
        Customer customer = new Customer();
        mv.addObject("customer", customer);
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("customer") Customer customer) {
        customerService.saveWithStoredProcedure(customer);
        return new ModelAndView("redirect:/customers/createForm");
    }
}
