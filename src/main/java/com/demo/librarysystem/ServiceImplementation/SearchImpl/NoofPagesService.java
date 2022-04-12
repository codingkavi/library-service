package com.demo.librarysystem.ServiceImplementation.SearchImpl;

import com.demo.librarysystem.BookService.LibraryService;
import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.ConvertJSON;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NoofPagesService implements LibraryService {
    public List<Map<String, Object>> findBook(int input1,int input2 ) throws SQLException {
        List<Map<String, Object>> data = searchbynoofPages(input1,input2);
        return data;
    }

    @Override
    public void findBooks(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Page Range to search : ");
        int input1 = Integer.parseInt(input.nextLine());
        int input2 = input.nextInt();
        try {
            searchbynoofPages(input1,input2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> searchbynoofPages(int input1, int input2) throws SQLException {

        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();

        PreparedStatement pstmt;
        pstmt = conn.prepareStatement("Select * from BookRepository where book_noofpages between ? and ? ");
        pstmt.setInt(1, input1);
        pstmt.setInt(2,input2);
        ResultSet rs = pstmt.executeQuery();
        ConvertJSON convertJSON = new ConvertJSON();
        List<Map<String, Object>> entities = convertJSON.getResult(rs);
        return entities;

        }
}
