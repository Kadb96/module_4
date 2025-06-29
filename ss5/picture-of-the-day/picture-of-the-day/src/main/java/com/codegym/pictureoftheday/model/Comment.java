package com.codegym.pictureoftheday.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comment implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long score;
    String author;
    String feedback;
    Long likeNumber = 0L;

    public Comment() {
    }

    public Comment(Long id, Long score, String author, String feedback, Long likeNumber) {
        this.id = id;
        this.score = score;
        this.author = author;
        this.feedback = feedback;
        this.likeNumber = likeNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Long likeNumber) {
        this.likeNumber = likeNumber;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Comment.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Comment comment = (Comment) target;
        String feedback = comment.getFeedback();

        if(feedback.matches("(fuck)")) {
            errors.rejectValue("feedback", "feedback.language");
        }
    }
}
