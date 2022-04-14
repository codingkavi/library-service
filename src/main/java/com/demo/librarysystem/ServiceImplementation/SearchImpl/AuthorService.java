package com.demo.librarysystem.ServiceImplementation.SearchImpl;
import com.demo.librarysystem.BookService.LibraryService;
import com.demo.librarysystem.model.Books;
import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.ConvertJSON;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AuthorService implements LibraryService {

    @Override
    public void findBooks() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the author name to search :");
        String bookSearch = input.nextLine();
        searchbyAuthor(bookSearch);
    }

    public List<Map<String, Object>> searchbyAuthor(String bookSearch) throws SQLException {

        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement("Select * from BookRepository where LOWER(author_name) like  '%'  || LOWER(?) || '%'",ResultSet.TYPE_SCROLL_INSENSITIVE);
        }catch (SQLException e){
            e.printStackTrace();
        }
        pstmt.setString(1, bookSearch);
        ResultSet resultSet = pstmt.executeQuery();
        ConvertJSON convertJSON = new ConvertJSON();
        List<Map<String, Object>> entities = convertJSON.getEntitesfromResultSet(resultSet);
        return entities;
    }

    public void updateAuthor(Books book) throws SQLException {
        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement preparedStatement ;
        preparedStatement = conn.prepareStatement("Update BookRepository SET author_name = ? ,book_title = ? where book_id = ?");
        preparedStatement.setString(1, book.getAuthor());
        System.out.println(book.getAuthor());
        preparedStatement.setString(2,book.getTitle());
        System.out.println(book.getTitle());
        preparedStatement.setInt(3,book.getBookId());
        int count = preparedStatement.executeUpdate();
        System.out.println(count + " rows updated");

    }
}
