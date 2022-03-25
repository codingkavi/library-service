package com.demo.librarysystem.util;
import com.demo.librarysystem.repository.ConnectDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CreateUsers {

        Scanner sc;
        HashMap<String,String> hashMap = new HashMap();

        public void create(String userId) throws SQLException {

            sc = new Scanner(System.in);
            ConnectDao dao = new ConnectDao();
            Connection conn = dao.connect();
            PreparedStatement pstmt;
            String query = "Select user_Name from UserAccountRepository where user_Name = '" + userId + "' ";
            pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            String[] message = {"First Name", "Last Name", "User Id", "password", "email",
                    "address", "dateofbirth", "contact"};

            int i = 0;
            while (i < message.length) {
                String input = getInput(message[i]);
                System.out.println(message[i] + " : " + input);
                i++;
            }

            for (Map.Entry<String, String> m : hashMap.entrySet()) {
                System.out.println(m.getKey() + " " + m.getValue());
            }

            if (!rs.next()) {
                String sql = "INSERT INTO UserAccountRepository"
                        + "(user_Name,first_name, last_name,password,user_email,address,DateofBirth,user_contact) VALUES"
                        + "(?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(1, hashMap.get("User Id"));
                preparedStatement.setString(2, hashMap.get("First Name"));
                preparedStatement.setString(3, hashMap.get("Last Name"));
                preparedStatement.setString(4, hashMap.get("password"));
                preparedStatement.setString(5, hashMap.get("email"));
                preparedStatement.setString(6, hashMap.get("address"));
                preparedStatement.setString(7, hashMap.get("dateofbirth"));
                preparedStatement.setString(8, hashMap.get("contact"));
                preparedStatement.executeUpdate();
            } else {
                System.out.println("User Exists with id : " + hashMap.get("User Id"));
            }
        }

    private String getInput(String message) {
        System.out.println("Enter the " + message + " : ");
        String input = sc.nextLine();
        hashMap.put(message, input);
        return input;
    }
}

