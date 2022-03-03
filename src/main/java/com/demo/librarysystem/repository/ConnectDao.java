package com.demo.librarysystem.repository;

import com.demo.librarysystem.model.Books;

import java.sql.*;

public class ConnectDao {
    Connection conn;
    String data;

        public void connect() throws SQLException {
            try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file:/Users/kavi/h2db/in-memory", "sa", "");

            } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            }
        }




        public void searchbyAuthor(String bookSearch) throws SQLException {

            connect();
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt;
            pstmt = conn.prepareStatement("Select * from BookRepository where LOWER(author_name) like  '%'  || LOWER(?) || '%'");
            pstmt.setString(1,  bookSearch  );
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                int bookId = rs.getInt("book_id");
                int ISBN = rs.getInt("book_ISBN");
                String author = rs.getString("author_name");
                String title = rs.getString("book_title");
                String key = rs.getString("key_search");
                data = "Book ID : " + " " + bookId + " \n" + "ISBN : " + ISBN + "\n" + "Author : " + author + " \n" + "Title : " + title +" " + " KeySearch" +key;
                System.out.println(data);
            }
        }

        public void searchbyTitle(String bookSearch)throws SQLException{
            connect();
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("Select * from BookRepository where UPPER(book_title) like '%' || UPPER(?) || '%'");
            pstmt.setString(1,  bookSearch);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                int bookId = rs.getInt("book_id");
                int ISBN = rs.getInt("book_ISBN");
                String author = rs.getString("author_name");
                String title = rs.getString("book_title");
                data = "Book ID : " + bookId + " \n" + "ISBN : " + ISBN + "\n"+"Author : " + author + "\n"+"Title : " + title;
                System.out.println(data);
            }
        }
        public void searchBynoofPages(int input1 , int input2) throws SQLException {
            connect();
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("Select * from BookRepository where book_noofpages between ? and ?");
            pstmt.setInt(1,input1);
            pstmt.setInt(2,input2);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                int bookId = rs.getInt("book_id");
                int ISBN = rs.getInt("book_ISBN");
                String author = rs.getString("author_name");
                String title = rs.getString("book_title");
                data = "Book ID : " + bookId + " \n" + "ISBN : " + ISBN + "\n"+"Author : " + author + "\n"+"Title : " + title;
                System.out.println(data);
            }
        }
        public void keySearch(String key) throws SQLException {
            connect();
            //Statement stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("Select * from BookRepository where key_search like ?");
            pstmt.setString(1, "%" + key + "%");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                int bookId = rs.getInt("book_id");
                int ISBN = rs.getInt("book_ISBN");
                String author = rs.getString("author_name");
                String title = rs.getString("book_title");
                String data = "Book ID : " + bookId + " \n" + "ISBN : " + ISBN + "\n"+"Author : " + author + "\n"+"Title : " + title;
                System.out.println(data);
            }
        }


}






