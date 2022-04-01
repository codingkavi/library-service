package com.demo.librarysystem.ServiceImplementation.Search;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.service.LibraryServ;
import com.demo.librarysystem.util.ConvertJSON;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class AuthorService implements LibraryServ {

    public List<Map<String, Object>> findBook(String bookSearch) throws SQLException {
        List<Map<String, Object>> data = searchbyAuthor(bookSearch);
        return data;
    }

    @Override
    public void findBooks() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the author name to search :");
        String bookSearch = input.nextLine();
        searchbyAuthor(bookSearch);
    }


    public List<Map<String, Object>> searchbyAuthor(String bookSearch) throws SQLException {

        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("Select * from BookRepository where LOWER(author_name) like  '%'  || LOWER(?) || '%'");
        }catch (SQLException e){
            e.printStackTrace();
        }
        pstmt.setString(1, bookSearch);
        ResultSet rs = pstmt.executeQuery();
        ConvertJSON convertJSON = new ConvertJSON();
        List<Map<String, Object>> entities = convertJSON.getResult(rs);
        return entities;

     /* while(rs.next()) {
            int bookId = rs.getInt("book_id");
            System.out.println(bookId);
            int ISBN = rs.getInt("book_ISBN");
            String author = rs.getString("author_name");
            String title = rs.getString("book_title");
            String publishername = rs.getString("Publisher");
            int year = rs.getInt("Year_Published");
            String key = rs.getString("key_search");
            String data = "Book ID : " + " " + bookId + " \n " + "ISBN : " + ISBN + " \n " + "Author : " + author + " \n " + "Title : " + title + " \n " + "Publisher : " + publishername + " \n " + "PublishedYear : " + year + "\n" +"KeySearch : " + key;*/
            /*//return data;
            ObjectMapper mapper = new ObjectMapper();
            String json = null;
            try {
                json= mapper.writeValueAsString(data);
                System.out.println(json);

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return json;*/
       // }

    }
    }

