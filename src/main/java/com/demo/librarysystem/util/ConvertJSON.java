package com.demo.librarysystem.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

        Map<String,Object> resultsMap = new HashMap<>();
         resultsMap.put("BookId", resultSet.getInt("book_id"));
         resultsMap.put("Author", resultSet.getString("author_name"));
         resultsMap.put("Title", resultSet.getString("book_title"));
         resultsMap.put("Isbn", resultSet.getInt("book_ISBN"));
         resultsMap.put("NoOfPages", resultSet.getInt("book_noofpages"));
         resultsMap.put("Publishername", resultSet.getString("Publisher"));
         resultsMap.put("Publishedyear", resultSet.getInt("Year_Published"));
         resultsMap.put("Key", resultSet.getString("key_search"));
         resultsMap.put("Genre", resultSet.getString("Genre"));
         return resultsMap;
    }
}

