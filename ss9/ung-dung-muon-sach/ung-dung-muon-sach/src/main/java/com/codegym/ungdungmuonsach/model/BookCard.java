package com.codegym.ungdungmuonsach.model;

import javax.persistence.*;

@Entity
public class BookCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private String borrowerName;
    private boolean isReturned = false;

    public BookCard() {
    }

    public BookCard(Long id, Book book, String borrowerName) {
        this.id = id;
        this.book = book;
        this.borrowerName = borrowerName;
    }

    public BookCard(Long id, Book book, String borrowerName, boolean isReturned) {
        this.id = id;
        this.book = book;
        this.borrowerName = borrowerName;
        this.isReturned = isReturned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
