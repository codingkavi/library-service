package com.demo.librarysystem.ServiceImplementation;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.service.LibraryServ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NoofPagesService implements LibraryServ {

    @Override
    public void findBooks(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Page Range to search : ");
        int input1 = Integer.parseInt(input.nextLine());
        int input2 = input.nextInt();
        try {
            searchbynoofPages(input1,input2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchbynoofPages(int input1, int input2) throws SQLException {

        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();

        PreparedStatement pstmt;
        pstmt = conn.prepareStatement("Select * from BookRepository where book_noofpages between ? and ? ");
        pstmt.setInt(1, input1);
        pstmt.setInt(2,input2);
        ResultSet rs = pstmt.executeQuery();


        while (rs.next()) {
            int bookId = rs.getInt("book_id");
            int ISBN = rs.getInt("book_ISBN");
            String author = rs.getString("author_name");
            String title = rs.getString("book_title");
            String publishername = rs.getString("Publisher");
            int year = rs.getInt("Year_Published");
            String key = rs.getString("key_search");
            String data = "Book ID : " + " " + bookId + " \n" + "ISBN : " + ISBN + "\n" + "Author : " + author + " \n" + "Title : " + title + "\n" +"PublisherName : " + publishername + "\n" + "PublishedYear : "+ year +"\n"+ "KeySearch : " + key;
            System.out.println(data);
        }
    }
}
