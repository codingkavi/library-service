package com.demo.librarysystem.service;
import com.demo.librarysystem.BookService.LibraryService;
import com.demo.librarysystem.model.Books;
import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.repository.EventRepository;
import com.demo.librarysystem.util.ConvertJSON;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AuthorService implements LibraryService {


    @Autowired
    EventRepository eventRepository;

    @Override
    public void findBooks() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the author name to search :");
        String bookSearch = input.nextLine();
        searchbyAuthor(bookSearch);

        //saveMethod();
    }

   /* public void saveMethod() {
        EventDto event = new EventDto();
        event.setEventType("Author Talks");
        event.setAudience("Adults");
        event.setLanguage("English");
        event.setLocation("Alpharetta");
        event.setProgram("Native-American Heritage Month");

        Event savedObject = eventRepository.save(event);
        System.out.println("savedObject.getEventId() -> " + savedObject.getEventId());
    }*/

    public List<Map<String, Object>> searchbyAuthor(String bookSearch) throws SQLException {

        ConnectDao dao = new ConnectDao();
        Connection conn = dao.connect();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement("Select * from BookRepository where UPPER(author_name) like  '%'  || UPPER(?) || '%'");
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
        preparedStatement = conn.prepareStatement("Update BookRepository SET author_name = ? ,book_title = ? ,book_ISBN = ? , book_noofpages = ? ,Publisher = ?,Year_Published = ? ,key_search = ? ,Genre = ? where book_id = ?");
        preparedStatement.setString(1, book.getAuthor());
        System.out.println(book.getAuthor());
        preparedStatement.setString(2,book.getTitle());
        System.out.println(book.getTitle());
        preparedStatement.setInt(3,book.getIsbn());
        preparedStatement.setInt(4,book.getNoOfPages());
        preparedStatement.setString(5, book.getPublisherName());
        preparedStatement.setInt(6,book.getPublishedYear());
        preparedStatement.setString(7, book.getKey());
        preparedStatement.setString(8, book.getGenre());
        preparedStatement.setInt(9,book.getBookId());
        int count = preparedStatement.executeUpdate();
        System.out.println(count + " rows updated");
    }
}
