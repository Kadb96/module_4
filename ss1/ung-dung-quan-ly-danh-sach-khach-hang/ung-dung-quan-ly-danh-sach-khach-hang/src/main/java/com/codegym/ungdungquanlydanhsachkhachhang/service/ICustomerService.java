package com.codegym.ungdungquanlydanhsachkhachhang.service;

import com.codegym.ungdungquanlydanhsachkhachhang.exception.DuplicateEmailException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService<E> {
    Page<E> findAll(Pageable pageable);
    Page<E> findAllByName(String name, Pageable pageable);
    Optional<E> findById(Long id);
    void save(E e) throws DuplicateEmailException;
    void remove(Long id);
}
