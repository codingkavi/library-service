package com.demo.librarysystem.ServiceImplementation.Delete;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.service.DeleteBooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDelete implements DeleteBooks {

    @Override
    public void delete() {

    }
    public void deleteById(int bookId) throws SQLException {
        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement("Delete from BookRepository where id = ?");
        pstmt.setInt(1,bookId);

    }
}
