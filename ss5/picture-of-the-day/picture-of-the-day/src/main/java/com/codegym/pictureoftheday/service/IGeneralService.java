package com.codegym.pictureoftheday.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAll();
    E findById(Long id);
    void save(E e);

}
