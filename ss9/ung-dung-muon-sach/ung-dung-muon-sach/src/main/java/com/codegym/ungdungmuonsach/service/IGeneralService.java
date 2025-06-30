package com.codegym.ungdungmuonsach.service;

import java.util.Optional;

public interface IGeneralService<E> {
    Iterable<E> findAll();
    Optional<E> findById(Long id);
    void save(E entity);
    void deleteById(Long id);
}
