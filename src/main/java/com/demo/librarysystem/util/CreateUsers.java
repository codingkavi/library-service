package com.demo.librarysystem.util;
import com.demo.librarysystem.repository.ConnectDao;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CreateUsers implements UserConst{

        static Scanner sc;
        static HashMap<String,String> hashMap = new HashMap();
        static ConnectDao dao = new ConnectDao();
        static Connection conn = dao.connect();
        static PreparedStatement pstmt;
        static ResultSet rs;


        public static void create(String userName) throws SQLException {

            sc = new Scanner(System.in);

            pstmt = conn.prepareStatement(QUERY_SELECT_USERNAME);
            pstmt.setString(1, userName);
            rs = pstmt.executeQuery();
            if (!rs.next()) {
                int i = 0;
                while (i < MESSAGE.length) {
                    String input = getInput(MESSAGE[i]);
                    System.out.println(MESSAGE[i] + " : " + input);
                    i++;
                }
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY_INSERT_FOR_LOGIN);

                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, hashMap.get("PASSWORD"));
                preparedStatement.setString(3, hashMap.get("FIRST NAME"));
                preparedStatement.setString(4, hashMap.get("LAST NAME"));
                preparedStatement.setString(5, hashMap.get("EMAIL"));
                preparedStatement.setString(6, hashMap.get("ADDRESS"));
                preparedStatement.setString(7, hashMap.get("DATEOFBIRTH"));
                preparedStatement.setString(8, hashMap.get("CONTACT"));
                preparedStatement.executeUpdate();
            } else {
                System.out.println("User Exists with id : " + userName);
            }
        }

        private static String getInput(String message) {
        System.out.println("Enter the " + message + " : ");
        String input = sc.nextLine();
        hashMap.put(message, input);
        return input;
    }
}

