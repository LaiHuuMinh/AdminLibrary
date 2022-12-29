package com.web.quanlythuvien.Dao.impl;

import com.web.quanlythuvien.Dao.IUserDao;
import com.web.quanlythuvien.exception.BusinessException;
import com.web.quanlythuvien.mapper.IRowMapper;
import com.web.quanlythuvien.mapper.UserMapper;
import com.web.quanlythuvien.model.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends AbstractDao<UserEntity> implements IUserDao {

    @Override
    public void add(UserEntity userEntity) {

        Connection connection = getConnection();
        String sqlQuery = "insert into thuvien.user( name, age, sex, numberPhone, username, password) VALUE (?,?,?,?,?,?);";
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, userEntity.getName());
            preparedStatement.setInt(2, userEntity.getAge());
            preparedStatement.setInt(3, userEntity.getSex());
            preparedStatement.setString(4, userEntity.getNumberPhone());
            preparedStatement.setString(5, userEntity.getUsername());
            preparedStatement.setString(6, userEntity.getPassword());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public List<UserEntity> findAll() {
        String sql = "select * from user";
        List<UserEntity> users = findByProperties(sql,new UserMapper());
        return users;    }

    @Override
    public UserEntity findById(Integer id) {
        String sql = "select * from user where id=?";
        List<UserEntity> userEntities = findByProperties(sql,new UserMapper(),id);
        if (userEntities.size() == 0){
            throw new BusinessException("user with id " + id + " not found");
        }
        return userEntities.get(0);
    }

    public void delete(UserEntity user){

        String sql ="delete from thuvien.user where id = ?";
        deleteForID(sql,user.getId());
    }

    @Override
    public void update(UserEntity user) {
        String sql = "update thuvien.user set name = ? , age = ?, sex = ?, numberPhone = ? where id = ?;";
        insert(sql,user.getName(),user.getAge(),user.getSex(),user.getNumberPhone(),user.getId());
    }


}
