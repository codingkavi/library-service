package com.demo.librarysystem.ServiceImplementation.SearchImpl;

import com.demo.librarysystem.BookService.LibraryService;
import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.ConvertJSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class bookIdService implements LibraryService {

    @Override
    public void findBooks() throws SQLException, JsonProcessingException {

    }

    public List<Map<String, Object>> searchbyId(int id) throws SQLException {
        System.out.println(id);
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
        List<Map<String, Object>> entities = convertJSON.getEntitesfromResultSet(rs);
        return entities;

    }
}

