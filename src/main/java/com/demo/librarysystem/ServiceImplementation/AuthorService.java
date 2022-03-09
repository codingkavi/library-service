package com.demo.librarysystem.ServiceImplementation;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.service.LibraryServ;

import java.sql.*;
import java.util.Scanner;

public class AuthorService implements LibraryServ {

    @Override
    public void searchBooksbyAuthor() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the author name to search :");
        String bookSearch = input.nextLine();
        searchbyAuthor(bookSearch);
    }
    public void searchbyAuthor(String bookSearch) throws SQLException {
        Connection conn = null;
        ConnectDao dao = new ConnectDao();
        dao.connect();

        PreparedStatement pstmt;
        pstmt = conn.prepareStatement("Select * from BookRepository where LOWER(author_name) like  '%'  || LOWER(?) || '%'");
        pstmt.setString(1,  bookSearch  );
        ResultSet rs = pstmt.executeQuery();


        while (rs.next()) {
            int bookId = rs.getInt("book_id");
            int ISBN = rs.getInt("book_ISBN");
            String author = rs.getString("author_name");
            String title = rs.getString("book_title");
            String publishername = rs.getString("Publisher");
            int year = rs.getInt("Year_Published");
            String key = rs.getString("key_search");
            String data = "Book ID : " + " " + bookId + " \n" + "ISBN : " + ISBN + "\n" + "Author : " + author + " \n" + "Title : " + title  +"\n"+ "KeySearch : " +key;
            System.out.println(data);
        }
    }

    @Override
    public void searchBooksbykeyword() {

    }

    @Override
    public void searchBooksbynoofPages() {

    }

    @Override
    public void searchBooksbyTitle() {

    }

    @Override
    public void searchBooksbyPublisher() {

    }
}
