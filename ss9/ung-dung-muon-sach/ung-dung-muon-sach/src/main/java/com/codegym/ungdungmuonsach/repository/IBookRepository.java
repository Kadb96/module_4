package com.codegym.ungdungmuonsach.repository;

import com.codegym.ungdungmuonsach.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBookRepository extends PagingAndSortingRepository<Book, Long> {
}
