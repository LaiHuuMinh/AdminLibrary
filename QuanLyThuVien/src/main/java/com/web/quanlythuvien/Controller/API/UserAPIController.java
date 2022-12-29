package com.web.quanlythuvien.Controller.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.quanlythuvien.dto.BaseResponse;
import com.web.quanlythuvien.model.entity.UserEntity;
import com.web.quanlythuvien.service.UserService;
import com.web.quanlythuvien.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user/api")
public class UserAPIController extends HttpServlet {
    private UserService service;

    public UserAPIController() {
        this.service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String ageStr = req.getParameter("age");
        List<UserEntity> userEntities = service.findByCondition(username,ageStr,name);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode("200");
        baseResponse.setMessage("success");
        baseResponse.setData(userEntities);

        ObjectMapper objectMapper = new ObjectMapper();

        String json =objectMapper.writeValueAsString(baseResponse);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print(json);
        writer.flush();
    }
}
