package com.web.quanlythuvien.service.impl;

import com.web.quanlythuvien.Dao.IBookDao;
import com.web.quanlythuvien.Dao.impl.BookDaoImpl;
import com.web.quanlythuvien.mapper.BookMapper;
import com.web.quanlythuvien.mapper.UserMapper;
import com.web.quanlythuvien.service.BookService;
import com.web.quanlythuvien.util.Book;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> seachBook(String name, String tacGia, String date) {

        BookDaoImpl iBookDao = new BookDaoImpl();
        StringBuilder sql = new StringBuilder("select *from thuvien.booklist where 1=1");
        if (name != null && !name.isEmpty()){
            sql.append(String.format(" and name = %s",name));
        }

        if (tacGia != null && !tacGia.isEmpty()){
            sql.append(String.format(" and tacGia = %s",tacGia));
        }

        if (!date.isEmpty() && date != null ){
            Integer dateSearch = Integer.parseInt(date.trim());
            sql.append(String.format(" and date = %d",dateSearch));
        }

        List<Book> books = iBookDao.findByProperties(sql.toString(),new BookMapper());
        return books;
    }
}
