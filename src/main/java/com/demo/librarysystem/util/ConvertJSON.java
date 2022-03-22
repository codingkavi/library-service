package com.demo.librarysystem.util;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ConvertJSON {

    public List<Map<String, Object>> getResult(ResultSet resultSet) throws SQLException {
        ArrayList<Map<String,Object>> entities = new ArrayList<>();
        while(resultSet.next()){
            entities.add(getData(resultSet));
        }
        return entities;
    }
   
    public Map<String, Object> getData(ResultSet resultSet) throws SQLException{
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        Map<String,Object> result = new HashMap<>();
        for(int i = 1; i <= columnCount; i++){
            String columnName = metaData.getColumnName(i);
            Object object = resultSet.getObject(i);
            result.put(columnName,object);
        }
        return result;
    }
}

