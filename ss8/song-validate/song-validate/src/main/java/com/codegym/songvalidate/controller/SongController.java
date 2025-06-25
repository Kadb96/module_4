package com.codegym.songvalidate.controller;

import com.codegym.songvalidate.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {
    @GetMapping("")
    public ModelAndView form() {
        ModelAndView mv = new ModelAndView("form");
        mv.addObject("song", new Song());
        return mv;
    }

    @PostMapping("/result")
    public ModelAndView result(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        new Song().validate(song, result);
        if (result.hasFieldErrors()) {
            return new ModelAndView("redirect:/songs");
        }
        ModelAndView mv = new ModelAndView("result");
        mv.addObject("song", song);
        return mv;
    }
}
