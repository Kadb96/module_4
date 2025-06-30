package com.codegym.ungdungmuonsach.service;

import com.codegym.ungdungmuonsach.exception.BookCardAlreadyReturned;
import com.codegym.ungdungmuonsach.exception.NotEnoughQuantityException;
import com.codegym.ungdungmuonsach.model.BookCard;

public interface IBookCardService extends IGeneralService<BookCard> {
    void saveBookCard(BookCard bookCard) throws NotEnoughQuantityException;
    void returnBook(Long id) throws BookCardAlreadyReturned;
}
