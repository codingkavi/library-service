package com.demo.librarysystem.ServiceImplementation;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.service.LibraryServ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class KeywordService implements LibraryServ {
//has a relationship(not an inheritance which is-a relatioship parent-child relationship)
    @Override
    public void searchBooksbykeyword() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the keyword to search a book : ");
        String key = input.nextLine();
        keySearch(key);
    }
    public void keySearch(String keyword) throws SQLException {
        Connection conn = null;
        ConnectDao dao = new ConnectDao();
        dao.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("Select * from BookRepository where key_search like ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pstmt.setString(1, "%" + keyword + "%");
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
    //Empty definitions
    @Override
    public  void searchBooksbyAuthor() {

    }

    @Override
    public void searchBooksbyPublisher() {

    }

    @Override
    public void searchBooksbyTitle() {

    }

    @Override
    public void searchBooksbynoofPages() {

    }


}
