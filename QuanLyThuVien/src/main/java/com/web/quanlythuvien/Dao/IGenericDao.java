package com.web.quanlythuvien.Dao;

import com.web.quanlythuvien.mapper.IRowMapper;

import java.util.List;

public interface IGenericDao<T>{
    // Object... params: truyen vao mot mang du lieu
    List<T> findByProperties(String sql, IRowMapper<T> mapper, Object... params);

}
