package com.demo.librarysystem;


import com.demo.librarysystem.model.Books;
import com.demo.librarysystem.model.Users;
import com.demo.librarysystem.service.UserService;
import com.demo.librarysystem.service.LibraryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Application.class, args);
        //createBooks();
        //createUsers();
        userLogin();


    }
    private static void userLogin() throws SQLException {
        LibraryService libraryService = new LibraryService();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the option to search");
        int option = in.nextInt();

        switch (option) {
            case 1:
                libraryService.searchBooksbyTitle();
                case 2:
                libraryService.searchBooksbyAuthor();
                case 3:
                libraryService.searchBooksbynoofPages();
                case 4:
                libraryService.searchBooksbykeyword();


        }
    }

    private static void createBooks() {
        ArrayList<Books> booksList = new ArrayList<>();
        // Static data for testing
        Books books1 = new Books( "J.K.Rowling", "Harry Potter", 123,40,"Harry","jk",1983);
        Books books2 = new Books( "HermannParisg", "Amelia Bedelia", 567,30,"Amelia","bnn",1994);
        Books books3 = new Books( "Norm Feuti", "Beak & Ally", 890,50,"Beak","mnn",1981);
        Books books4 = new Books( "Mo O'hara", "The Zombie Goldfish", 342,70,"Zombie","hjg",2011);
        Books books5 = new Books("Ursula","A Wizard Of EarthSea",432,55,"Wizard","huj",2013);
        Books books6 = new Books("Micheal Dahl","Troll Hunters",987,45,"Troll","ghg",2012);
        Books books7 = new Books("Kathryn","World Atlas",657,75,"World","ioi",2013);

        //adding the objects into ArrayList
        booksList.add(books1);
        booksList.add(books2);
        booksList.add(books3);
        booksList.add(books4);
        booksList.add(books5);
        booksList.add(books6);
        booksList.add(books7);

        LibraryService libraryService = new LibraryService();
        libraryService.addBooks(booksList);

        Books books = new Books();
        books.setBookId(123);
        books.setAuthor("J.K.Rowling");
        books.setTitle("Harry Potter Novels");
        books.setIsbn(12345);

        libraryService.addBook(books);
    }

    private static void createUsers() {
        ArrayList<Users> usersDetails = new ArrayList<>();
        Users users1 = new Users(11,"Sanvitha","sanvi@gmail.com",9823);
        Users users2 = new Users(12,"Anvith","Anvith@gmail.com",9723);
        Users users3 = new Users(13,"Kavitha","kavitha@gmail.com",9623);
        Users users4 = new Users(14,"Sankar","Sankar@gmail.com",9523);

        usersDetails.add(users1);
        usersDetails.add(users2);
        usersDetails.add(users3);
        usersDetails.add(users4);

        UserService userService = new UserService();
        userService.addUser(usersDetails);
    }

}

