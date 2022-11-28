package com.demo.librarysystem.util;

import com.demo.librarysystem.model.Books;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertToJson {

    public void singleEntity(ResultSet rs) throws SQLException, IOException {
        Books b = new Books();
        while(rs.next()){
            int bookId = rs.getInt("book_id");
            String author = rs.getString("author_name");
            String title = rs.getString("book_title");
            int isbn = rs.getInt("book_ISBN");
            int noofPages = rs.getInt("book_noofpages");
            String publisher = rs.getString("Publisher");
            int year = rs.getInt("Year_Published");
            String key = rs.getString("key_search");
            String genre = rs.getString("genre");

            b.setBookId(bookId);
            b.setAuthor(author);
            b.setTitle(title);
            b.setIsbn(isbn);
            b.setNoOfPages(noofPages);
            b.setPublisherName(publisher);
            b.setPublishedYear(year);
            b.setKey(key);
            b.setGenre(genre);

            File jsonFile = new File("/Users/kavi/workspace/Learning/target/bookInfo.json");
            ObjectMapper om = new ObjectMapper();
            om.writeValue(jsonFile,b);
        }
    }
}
