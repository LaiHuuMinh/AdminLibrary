package com.web.quanlythuvien.mapper;


import com.web.quanlythuvien.model.entity.UserEntity;
import com.web.quanlythuvien.util.Book;
import com.web.quanlythuvien.util.MapUtils;

import java.sql.ResultSet;

public class BookMapper implements IRowMapper<Book>{
    @Override
    public Book mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new Book(),resultSet);
    }
}
