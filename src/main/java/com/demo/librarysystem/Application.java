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

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //createBooks();
        //createUsers();
    }


    private static void createBooks() {
        ArrayList<Books> booksList = new ArrayList<>();
        // Static data for testing
        Books books1 = new Books( "J.K.Rowling", "Harry Potter", 123,40,"Harry","Bloomsbury Publishing",1983,"Fantasy");
        Books books2 = new Books( "Peggy Parish", "Amelia Bedelia", 567,30,"Amelia","Harper & Row",1963,"Children's picture book,comedy");
        Books books3 = new Books( "Norm Feuti", "Beak & Ally", 890,50,"Beak","HarperCollins",1981,"Comics");
        Books books4 = new Books( "Mo O'hara", "The Zombie Goldfish", 342,70,"Zombie","MacMillan",2011,"Fantasy");
        Books books5 = new Books("Ursula","A Wizard Of EarthSea",432,55,"Wizard","Parnassus",1968,"Fantasy");
        Books books6 = new Books("Micheal Dahl","Troll Hunters",987,45,"Troll","Print",2012,"Adventure");
        Books books7 = new Books("Kathryn","World Atlas",657,75,"World","Hammond",2013,"Sc-Fi");

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
        Users user5 = new Users(15,"Kala","kala@gmail.com",98765);
        Users user6 = new Users(16,"Bala","Bala@gmail.in",97643);
        Users user7 = new Users(17,"Dhandapani","Dhandapani@gmail.com",98654);

        usersDetails.add(users1);
        usersDetails.add(users2);
        usersDetails.add(users3);
        usersDetails.add(users4);
        usersDetails.add(user5);
        usersDetails.add(user6);
        usersDetails.add(user7);

        UserService userService = new UserService();
        userService.addUser(usersDetails);
    }

}

