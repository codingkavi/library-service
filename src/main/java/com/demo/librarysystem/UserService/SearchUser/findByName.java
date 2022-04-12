package com.demo.librarysystem.UserService.SearchUser;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.ConvertJSON;
import com.demo.librarysystem.util.findUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class findByName implements findUser {

    @Override
    public List<Map<String, Object>> findbyLastname(String lastname) throws SQLException {
        ConnectDao connectDao = new ConnectDao();
        Connection conn = connectDao.connect();
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement("Select * from UserRepository where last_name = ?");
        preparedStatement.setString(1,lastname);
        ResultSet resultSet = preparedStatement.executeQuery();
        ConvertJSON convertJSON = new ConvertJSON();
        List<Map<String, Object>> entities= convertJSON.getResult(resultSet);
        return entities;
    }
}
