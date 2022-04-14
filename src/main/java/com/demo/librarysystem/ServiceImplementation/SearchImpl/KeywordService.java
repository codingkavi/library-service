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

public class KeywordService implements LibraryService {

    @Override
    public void findBooks()  {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the keyword to search a book : ");
        String key = input.nextLine();

        try {
            keySearch(key);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public List<Map<String, Object>> keySearch(String keyword) throws SQLException,NullPointerException {

        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement("Select * from BookRepository where LOWER(key_search) like  '%'  || LOWER(?) || '%'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pstmt.setString(1,  keyword);
        ResultSet rs = pstmt.executeQuery();
        ConvertJSON convertJSON = new ConvertJSON();
        List<Map<String, Object>> entities = convertJSON.getEntitesfromResultSet(rs);
        return entities;

    }
}
