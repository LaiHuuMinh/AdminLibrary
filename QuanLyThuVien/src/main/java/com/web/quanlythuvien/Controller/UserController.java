package com.web.quanlythuvien.Controller;


import com.web.quanlythuvien.Dao.IUserDao;
import com.web.quanlythuvien.Dao.UserDao;
import com.web.quanlythuvien.Dao.impl.UserDaoImpl;
import com.web.quanlythuvien.model.entity.UserEntity;
import com.web.quanlythuvien.service.UserService;
import com.web.quanlythuvien.service.impl.UserServiceImpl;
import com.web.quanlythuvien.util.Contains;
import com.web.quanlythuvien.util.User;
import com.web.quanlythuvien.util.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "UserPage", urlPatterns = "/userPage")
public class UserController extends HttpServlet {
    private UserService service;
    public UserController() {
        this.service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String type = req.getParameter("type");

        StringBuilder view = new StringBuilder();


        if (!Util.isNullOrEmpty(type)){

            if (!Contains.ADD_ACTION.equals(type)){
                Integer idUser = Integer.parseInt(type);
                UserEntity userEntity = service.findById(idUser);
                req.setAttribute("userEdit",userEntity);
            }

            view.append("Page/UserAdd.jsp");

        }   else {

//            IUserDao userDao = new UserDaoImpl();
            List<UserEntity> userEntities = service.findAll();
            req.setAttribute("users", userEntities);
            view.append("Page/UserPage.jsp");

        }


        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view.toString());
        requestDispatcher.forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");


        if ("".equals(id)){
            UserEntity userEntity = getUserFromRequest(req);
            service.add(userEntity);
        }else {
            UserEntity userEntity = getUserFromRequest(req);
            userEntity.setId(Integer.parseInt(id));
            service.add(userEntity);
        }
//        IUserDao userDao = new UserDaoImpl();
        List<UserEntity> userEntities = service.findAll();
        req.setAttribute("users", userEntities);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Page/UserPage.jsp");
        requestDispatcher.forward(req,resp);
    }


    private UserEntity getUserFromRequest(HttpServletRequest req) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(req.getParameter("name"));
        userEntity.setAge(Integer.parseInt(req.getParameter("age")));
        userEntity.setNumberPhone( req.getParameter("numberPhone"));
        userEntity.setUsername(req.getParameter("username"));
        userEntity.setPassword(req.getParameter("password"));
        String sex = req.getParameter("sex");
        if ("Boy".equals(sex)){
            userEntity.setSex(0);
        }else {
            userEntity.setSex(1);
        }
        return userEntity;
    }
}
