package com.codegym.springsaveusername.controller;

import com.codegym.springsaveusername.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/login")
    public ModelAndView index(@CookieValue(value = "setUser", defaultValue = "") String setUser) {
        ModelAndView mv = new ModelAndView("login");
        Cookie cookie = new Cookie("setUser", setUser);
        mv.addObject("cookie", cookie);
        return mv;
    }

    @PostMapping("/doLogin")
    public ModelAndView doLogin(@ModelAttribute("user") User user,
                                @CookieValue(value = "setUser", defaultValue = "") String setUser,
                                HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("login");
        if (user.getUsername().equals("admin@gmail.com") && user.getPassword().equals("123456")) {
            if (user.getUsername() != null) {
                setUser = user.getUsername();
            }
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);

            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                if (!c.getName().equals("setUser")) {
                    c.setValue("");
                }
                mv.addObject("cookieValue", c);
            }
            mv.addObject("message", "Login Success. Welcome!");
        } else {
            user.setUsername("");
            Cookie cookie = new Cookie("setUser", setUser);
            mv.addObject("cookieValue", cookie);
            mv.addObject("message", "Login Failed. Try Again!");
        }
        return mv;
    }
}

