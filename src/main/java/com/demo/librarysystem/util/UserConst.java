package com.demo.librarysystem.util;

public interface UserConst {
     String[] MESSAGE = {"PASSWORD","FIRST NAME", "LAST NAME",  "EMAIL",
            "ADDRESS", "DATEOFBIRTH", "CONTACT"};

     //String TABLE_USERS = "UserAccountRepository";
     String QUERY_SELECT_USERNAME = "Select user_Name from UserAccountRepository where user_Name = ? ";

      String QUERY_INSERT_FOR_LOGIN ="INSERT INTO UserAccountRepository"
        + "(user_Name,first_name, last_name,password,user_email,address,DateofBirth,user_contact) VALUES"
        + "(?,?,?,?,?,?,?,?)";



}
