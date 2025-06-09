package com.codegym.ungdungquanlydanhsachkhachhang.repository;

import java.util.List;

public interface ICustomerRepository<E> {
    List<E> findAll();
    E findById(Long id);
    boolean save(E e);
    boolean remove(Long id);
}
