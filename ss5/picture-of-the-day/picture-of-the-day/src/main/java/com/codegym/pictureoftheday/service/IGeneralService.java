package com.codegym.pictureoftheday.service;

import com.codegym.pictureoftheday.model.Comment;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<E> {
    public Iterable<E> findAll(Pageable pageable);
    public Optional<E> findById(Long id);
    void save(E e);

}
