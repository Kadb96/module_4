package com.codegym.pictureoftheday.controller;

import com.codegym.pictureoftheday.model.Comment;
import com.codegym.pictureoftheday.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("comments", commentService.findAll());
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }

    @PostMapping("/comment")
    public ModelAndView addComment(@ModelAttribute("comment") Comment comment) {
        commentService.save(comment);
        ModelAndView modelAndView = new ModelAndView("redirect:/comments");
        return modelAndView;
    }

    @GetMapping("/like/{id}")
    public ModelAndView like(@PathVariable("id") Long id) {
        Comment comment = commentService.findById(id);
        commentService.save(new Comment(comment.getId(), comment.getScore(), comment.getAuthor(), comment.getFeedback(),
                comment.getLikeNumber() + 1));
        ModelAndView modelAndView = new ModelAndView("redirect:/comments");
        return modelAndView;
    }
}
