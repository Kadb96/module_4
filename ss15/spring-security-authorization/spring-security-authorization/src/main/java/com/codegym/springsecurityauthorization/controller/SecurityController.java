package com.codegym.springsecurityauthorization.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    private String getPrincipal(){
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @GetMapping(value = {"/", "/home"})
    public String Homepage(Model model) {
        model.addAttribute("user", getPrincipal());
        return "/welcome";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("user", getPrincipal());
        return "/admin";
    }

    @GetMapping( "/dba")
    public String dbaPage(Model model) {
        model.addAttribute("user", getPrincipal());
        return "/dba";
    }

    @GetMapping("/accessDenied")
    public String accessDeniedPage(Model model) {
        model.addAttribute("user", getPrincipal());
        return "/access_denied";
    }

}
