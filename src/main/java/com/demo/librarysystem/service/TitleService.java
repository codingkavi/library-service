package com.demo.librarysystem.service;

import com.demo.librarysystem.BookService.LibraryService;
import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.ConvertDB;
import com.demo.librarysystem.util.ConvertJSON;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TitleService implements LibraryService {

    @Override
    public void findBooks()  {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Title to search : ");
        String bookSearch = input.nextLine();
        try {
            searchbyTitle(bookSearch);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void searchbyTitle(String bookSearch) throws SQLException, NullPointerException, IOException {

        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("Select * from BookRepository where UPPER(book_title) like '%' || UPPER(?) || '%'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pstmt.setString(1,  bookSearch);

        ResultSet rs = pstmt.executeQuery();
        ConvertDB c = new ConvertDB();
        c.convert(rs);

    }
}