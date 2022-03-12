package com.demo.librarysystem.repository;
import java.sql.*;

public class ConnectDao {
    Connection conn;
    public Connection connect() {

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file:/Users/kavi/h2db/in-memory", "sa", "");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}









