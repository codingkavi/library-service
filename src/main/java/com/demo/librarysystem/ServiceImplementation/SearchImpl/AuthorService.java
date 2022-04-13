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
    Books book;

    public List<Map<String, Object>> findBook(String bookSearch) throws SQLException {
        List<Map<String, Object>> data = searchbyAuthor(bookSearch);
        return data;
    }

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
            pstmt = conn.prepareStatement("Select * from BookRepository where LOWER(author_name) like  '%'  || LOWER(?) || '%'");
        }catch (SQLException e){
            e.printStackTrace();
        }
        pstmt.setString(1, bookSearch);
        ResultSet resultSet = pstmt.executeQuery();

        while(resultSet.next()){
           //    resultSet.updateString("","");
            int id = resultSet.getInt("book_id");
            System.out.println(id);
            book.setBookId(id);
            int id1 = book.getBookId();
            System.out.println(id1);

            book.setAuthor(resultSet.getString("author_name"));
            book.setTitle(resultSet.getString("book_title"));
            book.setIsbn(resultSet.getInt("book_ISBN"));
            book.setNoOfPages(resultSet.getInt("book_noofpages"));
            book.setPublishername(resultSet.getString("Publisher"));
            book.setPublishedyear(resultSet.getInt("Year_Published"));
            book.setKey(resultSet.getString("key_search"));
            book.setGenre(resultSet.getString("Genre"));

        }


        ConvertJSON convertJSON = new ConvertJSON();
        List<Map<String, Object>> entities = convertJSON.getResult(resultSet);
        return entities;
    }

    public void updateAuthor(Books book) throws SQLException {
        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        Statement statement = conn.createStatement();
        PreparedStatement preparedStatement = null;
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
