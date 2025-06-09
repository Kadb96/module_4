package com.codegym.ungdungquanlydanhsachkhachhang.service;

import java.util.List;

public interface ICustomerService<E> {
    List<E> findAll();
    E findById(Long id);
    boolean save(E e);
    boolean remove(Long id);
}
