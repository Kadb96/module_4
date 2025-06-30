package com.codegym.ungdungmuonsach.controller;

import com.codegym.ungdungmuonsach.exception.NotEnoughQuantityException;
import com.codegym.ungdungmuonsach.model.Book;
import com.codegym.ungdungmuonsach.model.BookCard;
import com.codegym.ungdungmuonsach.service.BookCardService;
import com.codegym.ungdungmuonsach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookCardService bookCardService;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("books/index");
        Iterable<Book> books = bookService.findAll();
        mv.addObject("books", books);
        return mv;
    }

    @GetMapping("/show_add_form")
    public ModelAndView showAddForm() {
        ModelAndView mv = new ModelAndView("books/add_form");
        Book book = new Book();
        mv.addObject("book", book);
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView add(@Valid @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("books/add_form");
            return mv;
        }
        bookService.save(book);
        return new ModelAndView("redirect:/books");
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("books/view");
        Optional<Book> book = bookService.findById(id);
        mv.addObject("book", book.get());
        return mv;
    }

    @GetMapping("/show_borrow_form/{id}")
    public ModelAndView showBorrowForm(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("books/borrow_form");
        BookCard bookCard = new BookCard();
        Iterable<Book> books = bookService.findAll();
        mv.addObject("bookId", id);
        mv.addObject("bookCard", bookCard);
        mv.addObject("books", books);
        return mv;
    }

    @PostMapping("/borrow")
    public ModelAndView borrow(@ModelAttribute BookCard bookCard) throws NotEnoughQuantityException {
        bookCardService.saveBookCard(bookCard);
        ModelAndView mv = new ModelAndView("redirect:/book_cards");
        return mv;
    }

    @ExceptionHandler(NotEnoughQuantityException.class)
    public ModelAndView notEnoughQuantityException(NotEnoughQuantityException e) {
        ModelAndView mv = new ModelAndView("books/not_enough_quantity");
        return mv;
    }
}
