package com.web.quanlythuvien.Dao;

import com.web.quanlythuvien.util.Book;

import java.util.List;

public interface IBookDao {
    void add(Book book);
    List<Book> findAll();

    Book findById(Integer id);

    void update(Book book);
}
