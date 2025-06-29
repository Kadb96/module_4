package com.codegym.pictureoftheday.controller;

import com.codegym.pictureoftheday.model.Comment;
import com.codegym.pictureoftheday.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("")
    public ModelAndView index(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("comments", commentService.findAll(pageable));
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }

    @PostMapping("/comment")
    public ModelAndView addComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult bindingResult) {
        new Comment().validate(comment, bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("redirect:/comments");
            return modelAndView;
        }
        commentService.save(comment);
        ModelAndView modelAndView = new ModelAndView("redirect:/comments");
        return modelAndView;
    }

    @GetMapping("/like/{id}")
    public ModelAndView like(@PathVariable("id") Long id) {
        Optional<Comment> commentOptional = commentService.findById(id);
        Comment comment = commentOptional.get();
        commentService.save(new Comment(comment.getId(), comment.getScore(), comment.getAuthor(), comment.getFeedback(),
                comment.getLikeNumber() + 1));
        ModelAndView modelAndView = new ModelAndView("redirect:/comments");
        return modelAndView;
    }
}
