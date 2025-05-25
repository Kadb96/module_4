package com.codegym.ungdungquanlydanhsachkhachhang.controller;

import com.codegym.ungdungquanlydanhsachkhachhang.model.Customer;
import com.codegym.ungdungquanlydanhsachkhachhang.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/updateCustomers")
    public ModelAndView updateCustomer(@RequestParam Long customerId, @RequestParam String customerName,
                                @RequestParam String customerEmail, @RequestParam String customerAddress) {
        Customer customer = new Customer(customerId, customerName, customerEmail, customerAddress);
        customerService.updateCustomer(customer);
        return showList();
    }
}