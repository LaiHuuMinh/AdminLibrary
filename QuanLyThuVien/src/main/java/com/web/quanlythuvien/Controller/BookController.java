package com.web.quanlythuvien.Controller;

import com.web.quanlythuvien.Dao.BookDao;
import com.web.quanlythuvien.model.entity.UserEntity;
import com.web.quanlythuvien.service.BookService;
import com.web.quanlythuvien.service.impl.BookServiceImpl;
import com.web.quanlythuvien.util.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookList", urlPatterns = "/bookList")
public class BookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookDao bookDao = new BookDao();
        List<Book> bookList = bookDao.getListBook();
        req.setAttribute("books",bookList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Page/BookList.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String tacGia = req.getParameter("tacGia");
        String date = req.getParameter("date");


        BookService service = new BookServiceImpl();

        List<Book> books = service.seachBook(name,tacGia,date);
        req.setAttribute("books",books);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Page/BookList.jsp");
        requestDispatcher.forward(req,resp);
    }
}
