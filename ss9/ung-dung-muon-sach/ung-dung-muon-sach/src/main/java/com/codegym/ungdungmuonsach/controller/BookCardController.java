package com.codegym.ungdungmuonsach.controller;

import com.codegym.ungdungmuonsach.exception.BookCardAlreadyReturned;
import com.codegym.ungdungmuonsach.exception.NotEnoughQuantityException;
import com.codegym.ungdungmuonsach.model.Book;
import com.codegym.ungdungmuonsach.model.BookCard;
import com.codegym.ungdungmuonsach.service.BookCardService;
import com.codegym.ungdungmuonsach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book_cards")
public class BookCardController {
    @Autowired
    private BookCardService bookCardService;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("book_cards/index");
        Iterable<BookCard> bookCards = bookCardService.findAll();
        mv.addObject("bookCards", bookCards);
        return mv;
    }

    @GetMapping("/show_return_form")
    public ModelAndView showReturnForm() {
        ModelAndView mv = new ModelAndView("book_cards/return_form");
        BookCard bookCard = new BookCard();
        mv.addObject("bookCard", bookCard);
        return mv;
    }

    @PostMapping("/return")
    public ModelAndView returnBookCard(@RequestParam Long id) throws BookCardAlreadyReturned {
        bookCardService.returnBook(id);
        ModelAndView mv = new ModelAndView("redirect:/book_cards");
        return mv;
    }

    @ExceptionHandler(BookCardAlreadyReturned.class)
    public ModelAndView bookCardAlreadyReturn(BookCardAlreadyReturned e) {
        ModelAndView mv = new ModelAndView("book_cards/book_already_returned");
        return mv;
    }
}
