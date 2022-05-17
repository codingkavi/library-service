package com.demo.librarysystem.ServiceImplementation.SearchImpl;

import com.demo.librarysystem.BookService.LibraryService;
import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.ConvertJSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class bookIdService implements LibraryService {

    @Override
    public void findBooks() throws SQLException, JsonProcessingException {

    }

    public Map<String, Object> searchById(int id) throws SQLException {

        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement("Select * from BookRepository where book_id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        ConvertJSON convertJSON = new ConvertJSON();
        Map<String, Object> entity =  convertJSON.getEntityfromResultset(rs);
        return entity;

    }
}

