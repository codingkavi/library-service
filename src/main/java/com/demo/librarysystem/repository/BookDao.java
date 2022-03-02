package com.demo.librarysystem.repository;

import com.demo.librarysystem.Application;

import java.sql.*;

public class BookDao  {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt;
    public void connect(){
        try{
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file:file:/Users/kavi/h2db/employee-details","sa","");
           Statement stmt =  conn.createStatement();
           String query = "Select * from BookRepository";
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

            ResultSet rs = stmt.executeQuery(sql1);

            //System.out.println(rs.getString("book_ISBN"));

           while(rs.next()){
                System.out.println("ID : " +rs.getInt(1));
                //System.out.println("ISBN: "+rs.getInt(2));
                //System.out.println("AuthorName : "+rs.getString(3));
                //System.out.println("Title :" +rs.getString(4));

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
