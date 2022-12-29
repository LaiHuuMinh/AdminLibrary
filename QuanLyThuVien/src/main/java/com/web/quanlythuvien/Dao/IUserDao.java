package com.web.quanlythuvien.Dao;

import com.web.quanlythuvien.mapper.UserMapper;
import com.web.quanlythuvien.model.entity.UserEntity;

import java.util.List;

public interface IUserDao {
    void add(UserEntity userEntity);
    List<UserEntity> findAll();

    UserEntity findById(Integer id);

    void update(UserEntity user);

}
