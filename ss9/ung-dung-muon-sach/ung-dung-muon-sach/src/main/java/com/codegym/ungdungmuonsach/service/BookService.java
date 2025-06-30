package com.codegym.ungdungmuonsach.service;

import com.codegym.ungdungmuonsach.model.Book;
import com.codegym.ungdungmuonsach.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book entity) {
        bookRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
