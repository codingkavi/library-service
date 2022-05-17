package com.demo.librarysystem.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class ConvertJSON {

    public List<Map<String, Object>> getEntitesfromResultSet(ResultSet resultSet) throws SQLException {

        ArrayList<Map<String,Object>> entities = new ArrayList<>();

        while(resultSet.next()){
            entities.add(getEntityfromResultset(resultSet));
            System.out.println(entities);
        }
        return entities;
    }
   
    public Map<String, Object> getEntityfromResultset(ResultSet resultSet) throws SQLException{
        System.out.println(resultSet.getString("author_name"));
        Map<String,Object> resultsMap = new HashMap<>();
         resultsMap.put("bookId", resultSet.getInt("book_id"));
         resultsMap.put("author", resultSet.getString("author_name"));
         resultsMap.put("title", resultSet.getString("book_title"));
         resultsMap.put("isbn", resultSet.getInt("book_ISBN"));
         resultsMap.put("noOfPages", resultSet.getInt("book_noofpages"));
         resultsMap.put("publisherName", resultSet.getString("Publisher"));
         resultsMap.put("publishedYear", resultSet.getInt("Year_Published"));
         resultsMap.put("key", resultSet.getString("key_search"));
         resultsMap.put("genre", resultSet.getString("Genre"));
         return resultsMap;
    }
}

