package com.web.quanlythuvien.service;

import com.web.quanlythuvien.model.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity findById(Integer idUser);

    void add(UserEntity user);

    void delete(UserEntity user);
    List<UserEntity> findAll();

    List<UserEntity> findByCondition(String username,String age,String name);
}
