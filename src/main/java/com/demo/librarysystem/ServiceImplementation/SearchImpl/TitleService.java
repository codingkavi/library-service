package com.demo.librarysystem.ServiceImplementation.SearchImpl;

import com.demo.librarysystem.BookService.LibraryService;
import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.ConvertJSON;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TitleService implements LibraryService {

    @Override
    public void findBooks()  {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Title to search : ");
        String bookSearch = input.nextLine();
        try {
            searchbyTitle(bookSearch);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> findBook(String bookSearch) throws SQLException {
        List<Map<String, Object>> data = searchbyTitle(bookSearch);
        return data;
    }

    public List<Map<String, Object>> searchbyTitle(String bookSearch) throws SQLException,NullPointerException {

        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("Select * from BookRepository where UPPER(book_title) like '%' || UPPER(?) || '%'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pstmt.setString(1,  bookSearch);
        ResultSet rs = pstmt.executeQuery();

        ConvertJSON convertJSON = new ConvertJSON();
        List<Map<String, Object>> entities = convertJSON.getResult(rs);
        return entities;
    }
}
