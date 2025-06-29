package com.codegym.pictureoftheday.logger;

import com.codegym.pictureoftheday.model.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.concurrent.CompletionException;

@Aspect
@Component
public class Logger {
    @Before("execution(public * com.codegym.pictureoftheday.controller.CommentController.addComment(..))")
    public void addComment(JoinPoint joinPoint) {
        Comment comment = (Comment) joinPoint.getArgs()[0];
        BindingResult bindingResult = (BindingResult) joinPoint.getArgs()[1];
        if (bindingResult.hasErrors()) {
            System.out.println(comment.getAuthor() + " try to add comment " + comment.getFeedback());
        }
    }
}
