package com.codegym.ungdungmuonsach.service;

import com.codegym.ungdungmuonsach.exception.BookCardAlreadyReturned;
import com.codegym.ungdungmuonsach.exception.NotEnoughQuantityException;
import com.codegym.ungdungmuonsach.model.Book;
import com.codegym.ungdungmuonsach.model.BookCard;
import com.codegym.ungdungmuonsach.repository.IBookCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookCardService implements IBookCardService {
    @Autowired
    private IBookCardRepository bookCardRepository;

    @Autowired
    private IBookService bookService;

    @Override
    public Iterable<BookCard> findAll() {
        return bookCardRepository.findAll();
    }

    @Override
    public Optional<BookCard> findById(Long id) {
        return bookCardRepository.findById(id);
    }

    @Override
//    @Transactional
    public void save(BookCard entity) {
        bookCardRepository.save(entity);
    }

    @Override
    public void saveBookCard(BookCard bookCard) throws NotEnoughQuantityException {
        Book book = bookCard.getBook();
        if (book.getQuantity() == 0) {
            throw new NotEnoughQuantityException("Error: " + book.getTitle() + " current quantity is 0");
        } else {
            bookCardRepository.save(bookCard);
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);

        }
    }

    @Override
    public void returnBook(Long id) throws BookCardAlreadyReturned {
        BookCard bookCard = bookCardRepository.findById(id).get();
        if (bookCard.isReturned()) {
            throw new BookCardAlreadyReturned(bookCard.getId() + "is already returned");
        } else {
            bookCard.setReturned(true);
            Book book = bookCard.getBook();
            book.setQuantity(book.getQuantity() + 1);
            bookCardRepository.save(bookCard);
            bookService.save(book);
        }
    }


    @Override
    public void deleteById(Long id) {
        bookCardRepository.deleteById(id);
    }
}
