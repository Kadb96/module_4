package com.codegym.songvalidate.controller;

import com.codegym.songvalidate.model.Song;
import com.codegym.songvalidate.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<Song> songs = songService.findAll();
        mv.addObject("songs", songs);
        return mv;
    }

    @GetMapping("/addForm")
    public ModelAndView addForm() {
        ModelAndView mv = new ModelAndView("add_form");
        mv.addObject("song", new Song());
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView add(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        new Song().validate(song, result);
        if (result.hasFieldErrors()) {
            return new ModelAndView("redirect:/songs/addForm");
        } else {
            songService.save(song);
        }
        ModelAndView mv = new ModelAndView("redirect:/songs");
        return mv;
    }

    @GetMapping("/{id}/editForm")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("edit_form");
        Optional<Song> song = songService.findById(id);
        mv.addObject("song", song.get());
        return mv;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        new Song().validate(song, result);
        if (result.hasFieldErrors()) {
            return new ModelAndView("redirect:/songs/edit_form");
        } else {
            songService.save(song);
        }
        ModelAndView mv = new ModelAndView("redirect:/songs");
        return mv;
    }
}
