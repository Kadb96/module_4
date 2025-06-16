package com.codegym.uploadbaihat.controller;

import com.codegym.uploadbaihat.model.Song;
import com.codegym.uploadbaihat.model.SongUpload;
import com.codegym.uploadbaihat.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Value("${file-upload}")
    private String upload;

    @Autowired
    SongService songService;
    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        List<Song> songs = songService.findAll();
        mv.addObject("songs", songs);
        return mv;
    }

    @GetMapping("/save-form")
    public ModelAndView saveForm() {
        ModelAndView mv = new ModelAndView("save-form");
        SongUpload songUpload = new SongUpload();
        mv.addObject("song", songUpload);
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save(SongUpload songUpload) {
        MultipartFile multipartFile = songUpload.getPath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songUpload.getPath().getBytes(), new File(upload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songUpload.getId(), songUpload.getName(), songUpload.getArtist(), songUpload.getGenre() ,
                fileName);
        songService.save(song);
        return new ModelAndView("redirect:/songs");
    }
}
