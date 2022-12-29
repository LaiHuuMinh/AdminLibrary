package com.web.quanlythuvien.service;

import com.web.quanlythuvien.util.Book;

import java.util.List;

public interface BookService {
    List<Book> seachBook(String name, String tacGia, String date);
}
