package com.codegym.ungdungnghenhac.controller;

import com.codegym.ungdungnghenhac.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("songs", songService.findAll());
        return mv;
    }
}
