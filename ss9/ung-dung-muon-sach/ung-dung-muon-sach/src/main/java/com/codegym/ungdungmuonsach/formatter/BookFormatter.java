package com.codegym.ungdungmuonsach.formatter;

import com.codegym.ungdungmuonsach.model.Book;
import com.codegym.ungdungmuonsach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class BookFormatter implements Formatter<Book> {
    private IBookService bookService;

    @Autowired
    public BookFormatter(IBookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Book parse(String text, Locale locale) throws ParseException {
        Optional<Book> book = bookService.findById(Long.parseLong(text));
        return book.orElse(null);
    }

    @Override
    public String print(Book object, Locale locale) {
        return "[" + object.getId() + ", " + object.getTitle() + "]";
    }
}
