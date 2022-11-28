package com.demo.librarysystem.service;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.ConvertJSON;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class GetAllBooks {
    public List<Map<String, Object>> getAll() throws SQLException {
        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt;
        pstmt = conn.prepareStatement("Select * from BookRepository");
        ResultSet resultSet = pstmt.executeQuery();
        ConvertJSON convertJSON = new ConvertJSON();
        List<Map<String, Object>> entities = convertJSON.getEntitesfromResultSet(resultSet);
        return entities;
    }
}
