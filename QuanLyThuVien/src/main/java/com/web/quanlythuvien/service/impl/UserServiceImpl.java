package com.web.quanlythuvien.service.impl;



import com.web.quanlythuvien.Dao.IUserDao;
import com.web.quanlythuvien.Dao.impl.UserDaoImpl;
import com.web.quanlythuvien.mapper.UserMapper;
import com.web.quanlythuvien.model.entity.UserEntity;
import com.web.quanlythuvien.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {


    private UserDaoImpl userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public UserEntity findById(Integer idUser) {
        return userDao.findById(idUser);
    }

    @Override
    public void add(UserEntity user) {
        if (user.getId() == null){
            userDao.add(user);
        }else {
            userDao.update(user);
        }
    }

    @Override
    public void delete(UserEntity user) {

        userDao.delete(user);

    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    /*
        Sql Injection
     */
    @Override
    public List<UserEntity> findByCondition(String username, String age, String name) {
        Integer ageFinal = age.isEmpty() ? null : Integer.parseInt(age);
        StringBuilder sqlBuider = new StringBuilder("select * from user where 1=1");
        if (ageFinal != null){
            sqlBuider.append(String.format(" and age=%d",ageFinal));
        }
        if (!username.isEmpty()){
            sqlBuider.append(String.format(" and username='%s'",username));
        }
        if (!name.isEmpty()){

            sqlBuider.append(String.format(" and lower(name)=lower('%s')",name));
        }



//        return userDao.findById()

        return userDao.findByProperties(sqlBuider.toString(),new UserMapper());
    }
}
