package com.codegym.songvalidate.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String genre;

    public Song () {
    }

    public Song(Long id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Song.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        String title = song.getTitle();
        String author = song.getAuthor();
        String genre = song.getGenre();

        ValidationUtils.rejectIfEmpty(errors, "title", "title.empty");
        if (title.length() > 800) {
            errors.rejectValue("title", "title.length");
        }
        if (!title.matches("(^[a-zA-Z0-9]*$)")){
            errors.rejectValue("title", "title.format");
        }

        ValidationUtils.rejectIfEmpty(errors, "author", "author.empty");
        if (author.length() > 300) {
            errors.rejectValue("author", "author.length");
        }
        if (!author.matches("(^[a-zA-Z0-9]*$)")){
            errors.rejectValue("author", "author.format");
        }

        ValidationUtils.rejectIfEmpty(errors, "genre", "genre.empty");
        if (author.length() > 3000) {
            errors.rejectValue("genre", "genre.length");
        }
        if (!author.matches("(^[a-zA-Z0-9,]*$)")){
            errors.rejectValue("genre", "genre.format");
        }
    }
}
