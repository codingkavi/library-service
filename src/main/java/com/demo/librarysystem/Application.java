package com.demo.librarysystem;


import com.demo.librarysystem.model.Book;
import com.demo.librarysystem.model.User;
import com.demo.librarysystem.repository.BookDao;
import com.demo.librarysystem.repository.UserAccountRepository;
import com.demo.librarysystem.service.UserService;
import com.demo.librarysystem.service.LibraryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.JoinColumn;
import java.util.ArrayList;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        createBooks();
       // createUsers();
        BookDao dao = new BookDao();
        dao.connect();
    }

    private static void createBooks() {
        ArrayList<Book> bookList = new ArrayList<>();
        // Static data for testing
        Book book1 = new Book( "J.K.Rowling", "Harry Potter", 123);
        Book book2 = new Book( "HermannParisg", "Amelia Bedelia", 567);
        Book book3 = new Book( "Ford", "Germany", 890);
        Book book4 = new Book( "Suzuki", "canada", 342);

        //adding the objects into ArrayList
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);


        LibraryService libraryService = new LibraryService();
        libraryService.addBooks(bookList);

        Book book = new Book();
        book.setBookId(123);
        book.setAuthor("J.K.Rowling");
        book.setTitle("Harry Potter Novels");
        book.setIsbn(12345);

        libraryService.addBook(book);
    }



    private static void createUsers() {
        ArrayList<User> userDetails = new ArrayList<>();
        User user1 = new User(11,"Sanvitha","sanvi@gmail.com",9823);
        User user2 = new User(12,"Anvith","Anvith@gmail.com",9723);
        User user3 = new User(13,"Kavitha","kavitha@gmail.com",9623);
        User user4 = new User(14,"Sankar","Sankar@gmail.com",9523);

        userDetails.add(user1);
        userDetails.add(user2);
        userDetails.add(user3);
        userDetails.add(user4);


        UserService userService = new UserService();
        userService.addUser(userDetails);
    }
}
