package com.demo.librarysystem.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertToJson {

    public List<Map<String, Object>> getEntitiesFromResultset(ResultSet resultSet) throws SQLException {
        ArrayList<Map<String ,Object>> entities = new ArrayList<>();
        while(resultSet.next()){
            entities.add(getEntityFromResultset(resultSet));
        }
        return entities;
    }
    public Map<String, Object> getEntityFromResultset(ResultSet resultSet) throws SQLException {
        Map<String,Object> resultsMap = new HashMap<>();
        resultsMap.put("userName" , resultSet.getString("user_Name"));
        resultsMap.put("firstName" , resultSet.getString("first_name"));
        resultsMap.put("lastName" , resultSet.getString("last_name"));
        resultsMap.put("password" , resultSet.getString("password"));
        resultsMap.put("email" , resultSet.getString("user_email"));
        resultsMap.put("contact" , resultSet.getInt("user_contact"));
        resultsMap.put("address" , resultSet.getString("address"));
        resultsMap.put("birthDate" , resultSet.getString("DateofBirth"));
        return resultsMap;

    }
}
