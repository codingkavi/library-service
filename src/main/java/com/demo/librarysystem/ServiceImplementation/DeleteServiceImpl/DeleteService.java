package com.demo.librarysystem.ServiceImplementation.DeleteServiceImpl;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.BookService.DeleteBooks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteService implements DeleteBooks {

    @Override
    public void delete() {

    }
    public void deleteById(int bookId) throws SQLException {
        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt;
        pstmt = conn.prepareStatement("Delete from BookRepository where book_id = ?");
        pstmt.setInt(1,bookId);
        int count = pstmt.executeUpdate();
        System.out.println(count +" rows affected");
    }
}
