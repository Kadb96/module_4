package com.codegym.ungdungquanlydanhsachkhachhang.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService<E> {
    Page<E> findAll(Pageable pageable) throws Exception;
    Page<E> findAllByName(String name, Pageable pageable);
    Optional<E> findById(Long id);
    void save(E e);
    void remove(Long id);
}
