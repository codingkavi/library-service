package com.demo.librarysystem.ServiceImplementation.DeleteServiceImpl;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.BookService.DeleteBooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteServiceByAuthor implements DeleteBooks {


    @Override
    public void delete() {

    }

    public void deleteByAuthor(String author) throws SQLException {
        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt;
        pstmt = conn.prepareStatement("Delete from BookRepository where author_name = ?");
        pstmt.setString(1,author);
        int count = pstmt.executeUpdate();
        System.out.println(count +" rows affected");

    }
}
