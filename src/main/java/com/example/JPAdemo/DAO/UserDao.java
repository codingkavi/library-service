package com.example.JPAdemo.DAO;

import com.example.JPAdemo.EmployeeApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class UserDao extends EmployeeApplication {
    Connection conn;
    PreparedStatement statement;
    Statement stmt;
    String csvfilePath = "/Users/kavi/downloads/spread.csv";

    public void readFile() throws SQLException, FileNotFoundException {

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:mem:employee-details", "sa", "");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE ACCOUNTHOLDER " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " first VARCHAR(255) not NULL, " +
                    " last VARCHAR(255) not NULL, " +
                    " age INTEGER not NULL, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Table Created for Library");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUserDetails() throws SQLException, IOException {
        String insertValue = "INSERT INTO ACCOUNTHOLDER (first, last, age) VALUES(?,?,?)";
        statement = conn.prepareStatement(insertValue, Statement.RETURN_GENERATED_KEYS);
       // ResultSet rs = statement.getGeneratedKeys();

        //int autoId = rs.getInt(1);
        //System.out.println(autoId);
        //statement.setInt(1, autoId);

        BufferedReader lineReader = new BufferedReader(new FileReader(csvfilePath));
        String lineText = null;
        try {
            lineReader.readLine();  // skip header line

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                //String ID = data[0];
                String firstName = data[1];
                String lastName = data[2];
                String Age = data[3];

                //statement.setInt(1, id);
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                int age = Integer.parseInt(Age);
                statement.setInt(3, age);
                statement.executeUpdate();
                //statement.addBatch();
                //statement.executeBatch();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeData() throws SQLException {
        String sql = "DELETE from ACCOUNTHOLDER where id =6";
        stmt.executeUpdate(sql);
    }

    public void updateData() throws SQLException {

        String sqlUpdate = "UPDATE ACCOUNTHOLDER SET first = 'RAMA' Where id = 5;";
        int count = stmt.executeUpdate(sqlUpdate);
        System.out.println(count + " " + "rows affected");
    }
}
