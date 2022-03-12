package com.demo.librarysystem.ServiceImplementation;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.service.LibraryServ;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Scanner;


public class AuthorService implements LibraryServ {


    @Override
    public void findBooks() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the author name to search :");
        String bookSearch = input.nextLine();
        try {
            searchbyAuthor(bookSearch);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchbyAuthor(String bookSearch) throws SQLException {

        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt;
        pstmt = conn.prepareStatement("Select * from BookRepository where LOWER(author_name) like  '%'  || LOWER(?) || '%'");
        pstmt.setString(1, bookSearch);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int bookId = rs.getInt("book_id");
            int ISBN = rs.getInt("book_ISBN");
            String author = rs.getString("author_name");
            String title = rs.getString("book_title");
            String publishername = rs.getString("Publisher");
            int year = rs.getInt("Year_Published");
            String key = rs.getString("key_search");
            String data = "Book ID : " + " " + bookId + " \n" + "ISBN : " + ISBN + "\n" + "Author : " + author + " \n" + "Title : " + title + "\n" + "KeySearch : " + key;
            System.out.println(data);
        }
    }
}



