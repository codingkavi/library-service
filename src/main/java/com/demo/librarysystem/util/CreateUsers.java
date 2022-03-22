package com.demo.librarysystem.util;

import com.demo.librarysystem.repository.ConnectDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateUsers {
    public void create(String userId) throws SQLException {
        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();

        PreparedStatement pstmt;
        String query = "Select user_Name from UserAccountRepository where user_Name = '" + userId + "' ";
        pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        Scanner sc = new Scanner(System.in);

        if (!rs.next()) {
            System.out.println("Enter the FirstName : ");
            String firstname = sc.nextLine();
            System.out.println("Enter the LastName : ");
            String lastname = sc.nextLine();
            System.out.println("Enter the Password : ");
            String password = sc.nextLine();
            System.out.println("Enter the Email : ");
            String email = sc.nextLine();
            System.out.println("Enter the Address : ");
            String address = sc.nextLine();
            System.out.println("Enter the DateOfBirth : ");
            String dateofbirth = sc.nextLine();
            System.out.println("Enter the Contact number  : ");
            int contact = sc.nextInt();

            String sql = "INSERT INTO UserAccountRepository"
                    + "(user_Name,first_name, last_name,password,user_email,address,DateofBirth,user_contact) VALUES"
                    + "(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

               preparedStatement.setString(1, userId);
                preparedStatement.setString(2, firstname);
                preparedStatement.setString(3, lastname);
                preparedStatement.setString(4, password);
                preparedStatement.setString(5, email);
                preparedStatement.setString(6, address);
                preparedStatement.setString(7, dateofbirth);
                preparedStatement.setInt(8, contact);
                preparedStatement.executeUpdate();
            }
        else{
            System.out.println("User Exists with id : " + userId);
        }
    }
}

