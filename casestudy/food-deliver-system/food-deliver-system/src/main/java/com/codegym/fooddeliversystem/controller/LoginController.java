package com.codegym.fooddeliversystem.controller;

import com.codegym.fooddeliversystem.model.Role;
import com.codegym.fooddeliversystem.model.User;
import com.codegym.fooddeliversystem.model.UserPrincipal;
import com.codegym.fooddeliversystem.model.dto.UserDto;
import com.codegym.fooddeliversystem.service.IRoleService;
import com.codegym.fooddeliversystem.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes ("userSession")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    private IRoleService roleService;

    @ModelAttribute("userSession")
    public User setUpUser() {
        return new User();
    }


    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("/users/login");
        return modelAndView;
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute("userSession") User userSession, @RequestParam String username, @RequestParam String password) {
//        User user = userService.findByUsername(username);
//        if (user == null || !userService.checkPassword(username, password)) {
//            return "redirect:/login?error";
//        }
//        userSession.setUsername(user.getUsername());
//        userSession.setRoles(user.getRoles());
//        userSession.setId(user.getId());
//        return "redirect:/profile";
//    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView("/users/profile");
        Role roleOwner = roleService.findByName("ROLE_OWNER").get();
        modelAndView.addObject("roleOwner", roleOwner);
        return modelAndView;
    }

    @GetMapping("/registry")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("users/registry");
        UserDto userDto = new UserDto();
        modelAndView.addObject("user", userDto);
        Iterable<Role> roles = roleService.findAll();
        modelAndView.addObject("roles", roles);
        Role role = new Role();
        modelAndView.addObject("role", role);
        return modelAndView;
    }

//    @PostMapping("/registry")
//    public ModelAndView processRegister(@ModelAttribute("user") UserDto userDto) {
//        userService.save(userDto);
//        return new ModelAndView("redirect:/");
//    }

//    private User getPrincipal() {
//        String userName;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            userName = ((UserDetails) principal).getUsername();
//        } else {
//            userName = principal.toString();
//        }
//        User user = userService.findByUsername(userName);
//        return user;
//    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, UserPrincipal principal){
        System.out.println(principal.getUsername());
        return userService.verify(user);
    }
}
