package com.demo.librarysystem.ServiceImplementation;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.service.LibraryServ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class YearService implements LibraryServ {
    @Override
    public void findBooks()  {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Publisher name to search : ");
        int bookSearch = input.nextInt();
        try {
            searchbyYear(bookSearch);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void searchbyYear(int bookSearch) throws SQLException {
        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("Select * from BookRepository where Year_Published = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pstmt.setInt(1,  bookSearch);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int bookId = rs.getInt("book_id");
            int ISBN = rs.getInt("book_ISBN");
            String author = rs.getString("author_name");
            String title = rs.getString("book_title");
            String publishername = rs.getString("Publisher");
            int year = rs.getInt("Year_Published");
            String key = rs.getString("key_search");
            String data = "Book ID : " + bookId + " \n" + "ISBN : " + ISBN + "\n" + "Author : " + author + "\n" + "Title : " + title + "\n" + "PublisherName : " + publishername + "\n" + "PublishedYear : " + year + "\n" + "KeySearch : " + key;
            System.out.println(data);
        }
    }


}

