package com.demo.librarysystem.UserService;

public interface UserConst {
     String[] MESSAGE = {"PASSWORD","FIRST NAME", "LAST NAME",  "EMAIL",
            "ADDRESS", "DATEOFBIRTH", "CONTACT"};

     //String TABLE_USERS = "UserAccountRepository";
     String QUERY_SELECT_USERNAME = "Select user_Name from UserAccountRepository where user_Name = ? ";

      String QUERY_INSERT_FOR_LOGIN ="INSERT INTO UserAccountRepository"
        + "(user_Name,password,first_name, last_name,user_email,address,DateofBirth,user_contact) VALUES"
        + "(?,?,?,?,?,?,?,?)";



}
