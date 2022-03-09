package com.demo.librarysystem.ServiceImplementation;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.service.LibraryServ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PublisherService implements LibraryServ {
    @Override
    public void searchBooksbyPublisher() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Publisher name to search : ");
        String bookSearch = input.nextLine();
        searchbyPublisher(bookSearch);
    }
    public void searchbyPublisher(String bookSearch) throws SQLException {
        Connection conn = null;
        ConnectDao dao = new ConnectDao();
        dao.connect();
        PreparedStatement pstmt = conn.prepareStatement("Select * from BookRepository where Publisher = ?");
        pstmt.setString(1,bookSearch);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            int bookId = rs.getInt("book_id");
            int ISBN = rs.getInt("book_ISBN");
            String author = rs.getString("author_name");
            String title = rs.getString("book_title");
            String publishername = rs.getString("Publisher");
            int year = rs.getInt("Year_Published");
            String key = rs.getString("key_search");
            String data = "Book ID : " + " " + bookId + " \n" + "ISBN : " + ISBN + "\n" + "Author : " + author + " \n" + "Title : " + title + "\n" +"PublisherName : " + publishername + "\n" + "PublishedYear : "+ year +"\n" +"KeySearch : " +key;
            System.out.println(data);
        }
    }

    @Override
    public void searchBooksbyAuthor() {
    System.out.println("hi");
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
}
