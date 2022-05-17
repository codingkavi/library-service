package com.demo.librarysystem.UserService.SearchUser;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.ConvertJSON;
import com.demo.librarysystem.UserService.findUser;
import com.demo.librarysystem.util.ConvertToJson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ServiceImpl implements findUser {

    @Override
    public List<Map<String, Object>> findByLastname(String lastname) throws SQLException {
        ConnectDao connectDao = new ConnectDao();
        Connection conn = connectDao.connect();
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement("Select * from UserAccountRepository where last_name = ?");
        preparedStatement.setString(1,lastname);
        ResultSet resultSet = preparedStatement.executeQuery();
        ConvertToJson convertJSON = new ConvertToJson();
        List<Map<String, Object>> entities= convertJSON.getEntitiesFromResultset(resultSet);
        return entities;
    }
    public void deletebyname(String username) throws SQLException {
        ConnectDao connectDao = new ConnectDao();
        Connection conn = connectDao.connect();
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement("Delete UserAccountRepository where user_Name = ?");
        preparedStatement.setString(1, username);
       int count =  preparedStatement.executeUpdate();
       System.out.println(count + " rows affected");
    }


}
