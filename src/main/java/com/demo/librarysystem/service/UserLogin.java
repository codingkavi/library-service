package com.demo.librarysystem.service;

import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.CreateUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class UserLogin {
    public void register() throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the UserName : ");
        String userId = sc.nextLine();
        CreateUsers createUsers = new CreateUsers();
        createUsers.create(userId);

    }
}



