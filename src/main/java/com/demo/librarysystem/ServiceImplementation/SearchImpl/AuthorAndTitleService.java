package com.demo.librarysystem.ServiceImplementation.SearchImpl;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.ConvertJSON;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AuthorAndTitleService{

    public List<Map<String, Object>> searchbyAuthorAndTitle(String author, String title) throws SQLException {
        ConnectDao connectDao = new ConnectDao();
        Connection conn = connectDao.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("Select * from BookRepository where author_name = ? and book_title = ?");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        pstmt.setString(1, author);
        pstmt.setString(2, title);
        ResultSet resultSet = pstmt.executeQuery();

        ConvertJSON convertJSON = new ConvertJSON();
        List<Map<String, Object>> entities = convertJSON.getEntitesfromResultSet(resultSet);
        return entities;
    }
}
