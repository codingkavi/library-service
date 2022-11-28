package com.demo.librarysystem.service;

import com.demo.librarysystem.BookService.LibraryService;
import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.ConvertJSON;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PublisherService implements LibraryService {

    public List<Map<String, Object>> findBook(String bookSearch) throws SQLException {
        List<Map<String, Object>> data = searchbyPublisher(bookSearch);
        return data;
    }


    @Override
    public void findBooks(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Publisher name to search : ");
        String bookSearch = input.nextLine();
        try {
            searchbyPublisher(bookSearch);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> searchbyPublisher(String bookSearch) throws SQLException {

        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt = conn.prepareStatement("Select * from BookRepository where LOWER(Publisher) like  '%'  || LOWER(?) || '%'");
        pstmt.setString(1,bookSearch);
        ResultSet rs = pstmt.executeQuery();
        ConvertJSON convertJSON = new ConvertJSON();
        List<Map<String, Object>> entities = convertJSON.getEntitesfromResultSet(rs);
        return entities;
    }
}
