package com.codegym.ungdungquanlydanhsachkhachhang.controller;

import com.codegym.ungdungquanlydanhsachkhachhang.exception.DuplicateEmailException;
import com.codegym.ungdungquanlydanhsachkhachhang.model.Customer;
import com.codegym.ungdungquanlydanhsachkhachhang.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService<Customer> customerService;

    @GetMapping()
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable) {
        try {
            Page<Customer> customers = customerService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("customers", customers);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/search")
    public ModelAndView showSearchList(@PageableDefault(value = 5) Pageable pageable,
                                       @RequestParam("search") Optional<String> search) {
        try {
            Page<Customer> customers;
            if (search.isPresent()) {
                customers = customerService.findAllByName(search.get(), pageable);
            } else {
                customers = customerService.findAll(pageable);
            }
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("search", search.get());
            modelAndView.addObject("customers", customers);
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) throws Exception {
            customerService.save(customer);
            return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView update(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("update");
        Optional<Customer> customer = customerService.findById(id);
        modelAndView.addObject("customer", customer.get());
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Customer customer) throws Exception{
            customerService.save(customer);
            return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id).get());
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("view");
        Optional<Customer> customer = customerService.findById(id);
        modelAndView.addObject("customer", customer.get());
        return modelAndView;
    }

    @ExceptionHandler
    public String handleException(Exception e) {
        return "input_not_acceptable";
    }
}