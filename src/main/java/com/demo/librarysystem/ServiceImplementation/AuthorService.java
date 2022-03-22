package com.demo.librarysystem.ServiceImplementation;

import com.demo.librarysystem.model.Books;
import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.service.LibraryServ;
import com.demo.librarysystem.util.ConvertJSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

public class AuthorService implements LibraryServ {

    @Override
    public void findBooks() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the author name to search :");
        String bookSearch = input.nextLine();
        //try {
           searchbyAuthor(bookSearch);
            //System.out.println(rs);
            /*ConvertJSON c = new ConvertJSON();
            List<Map<String,Object>> resultMap =  c.getResult(rs);
            System.out.println(resultMap);
        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
        }*/
    }

    public void searchbyAuthor(String bookSearch) throws SQLException {

        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt;
        pstmt = conn.prepareStatement("Select * from BookRepository where LOWER(author_name) like  '%'  || LOWER(?) || '%'");
        pstmt.setString(1, bookSearch);
        ResultSet rs = pstmt.executeQuery();
        //return rs;
        while (rs.next()) {
            int bookId = rs.getInt("book_id");
            int ISBN = rs.getInt("book_ISBN");
            String author = rs.getString("author_name");
            String title = rs.getString("book_title");
            String publishername = rs.getString("Publisher");
            int year = rs.getInt("Year_Published");
            String key = rs.getString("key_search");
            String data = "Book ID : " + " " + bookId + " , " + "ISBN : " + ISBN + " , " + "Author : " + author + " , " + "Title : " + title + " , " + "KeySearch : " + key;

            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = mapper.writeValueAsString(data);
                System.out.println("ResultingJSONstring = " + json);

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
    }
}
