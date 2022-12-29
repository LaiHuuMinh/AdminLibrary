package com.web.quanlythuvien.mapper;


import com.web.quanlythuvien.model.entity.UserEntity;
import com.web.quanlythuvien.util.MapUtils;

import java.sql.ResultSet;

public class UserMapper implements IRowMapper<UserEntity>{
    @Override
    public UserEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new UserEntity(),resultSet);
    }
}
