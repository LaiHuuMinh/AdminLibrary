package com.web.quanlythuvien.Dao;

import com.web.quanlythuvien.Dao.impl.ConnectMySQL;
import com.web.quanlythuvien.util.Book;
import com.web.quanlythuvien.util.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {


    public List<Book> getListBook(){

        List<Book> books = new ArrayList<>();

        String sqlQuery = "select *from thuvien.booklist;";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        Connection connection = connectMySQL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setTacGia(resultSet.getString("tacGia"));
                book.setDate(resultSet.getInt("date"));
                book.setCountry(resultSet.getString("country"));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return books;

    }

}
