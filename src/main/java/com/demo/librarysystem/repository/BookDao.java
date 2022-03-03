package com.demo.librarysystem.repository;

import com.demo.librarysystem.Application;

import java.sql.*;

public class BookDao  {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt;

    public void connect(String bookSearch){
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file:/Users/kavi/h2db/in-memory", "sa", "");
            Statement stmt = conn.createStatement();
            //String sql = "Select * from BookRepository where author_name ='HermannParisg';";
           /*String query = "Select * from BookRepository";
            String sql3 = "SELECT TOP 3 book_ISBN \n" +
                    "FROM \n" +
                    "    (SELECT TOP 3 book_ISBN \n" +
                    "     FROM BookRepository \n" +
                    "     ORDER BY book_ISBN DESC) AS BookRepository \n" +
                    "ORDER BY book_ISBN DESC";
            String sql4 ="DELETE FROM BookRepository" +
                    "            WHERE bookId = 9 ;";

            String sql = "SELECT * FROM BookRepository WHERE book_ISBN=(SELECT MAX (book_ISBN) FROM BookRepository)";

            String sql1 = "SELECT  MAX(book_ISBN) FROM BookRepository WHERE book_ISBN NOT in (SELECT MAX(book_ISBN) FROM BookRepository)";


*/
           /* ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()){
                System.out.println("ID : " +rs.getInt(1));
                System.out.println("ISBN: "+rs.getInt(2));
                System.out.println("AuthorName : "+rs.getString(3));
                System.out.println("Title :" +rs.getString(4));

            }*/
            pstmt = conn.prepareStatement("Select * from BookRepository where author_name = ?");
            pstmt.setString(1, bookSearch);
            ResultSet rs = pstmt.executeQuery();

            String data;
            while (rs.next()) {
                int bookId = rs.getInt("book_id");
                int ISBN = rs.getInt("book_ISBN");
                String author = rs.getString("author_name");
                String title = rs.getString("book_title");
                data = "Book ID : " + " " + bookId + " \n"+"ISBN : " + ISBN +"\n "+"Author : " + author + " \n"+"Title : " + title;
                System.out.println(data);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
