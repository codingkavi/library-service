package com.demo.librarysystem.UserService;

import java.sql.SQLException;
import java.util.Scanner;



public class Login implements UserConst {
    public void register() throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the UserName : ");
        String userName = sc.nextLine();
        CreateUsers createUsers = new CreateUsers();
        createUsers.create(userName);

    }
}



