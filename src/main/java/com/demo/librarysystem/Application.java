package com.demo.librarysystem;

import com.demo.librarysystem.ServiceImplementation.*;
import com.demo.librarysystem.Validations.PhoneValidation;
import com.demo.librarysystem.model.Books;
import com.demo.librarysystem.model.Users;
import com.demo.librarysystem.service.LibraryServ;
import com.demo.librarysystem.service.LibraryService;
import com.demo.librarysystem.service.UserLogin;
import com.demo.librarysystem.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SQLException, JsonProcessingException {
        SpringApplication.run(Application.class, args);

        //createBooks();
        //createUsers();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome User!");
            System.out.println("To find books, please select from one of the below options");
            System.out.println("1. Author");
            System.out.println("2. Title");
            System.out.println("3. Publisher");
            System.out.println("4. Keyword");
            System.out.println("5. Page range");
            System.out.println("6. Year");
            System.out.println("7. Exit");

            System.out.println("Enter your option: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    LibraryServ libraryServ = new AuthorService();
                    libraryServ.findBooks();
                    sc.nextLine();
                    break;
                case 2:
                    LibraryServ libraryServ1 = new TitleService();
                    libraryServ1.findBooks();
                    sc.nextLine();
                    break;
                case 3:
                    LibraryServ libraryServ2 = new PublisherService();
                    libraryServ2.findBooks();
                    sc.nextLine();
                    break;
                case 4:
                    LibraryServ libraryServ3 = new KeywordService();
                    libraryServ3.findBooks();
                    sc.nextLine();
                    break;
                case 5:
                    LibraryServ libraryServ4 = new NoofPagesService();
                    libraryServ4.findBooks();
                    sc.nextLine();
                    break;
                case 6:
                    LibraryServ libraryServ5 = new YearService();
                    libraryServ5.findBooks();
                    sc.nextLine();
                    break;
                case 7:
                    System.exit(0);
                case 8:
                    UserLogin userLogin = new UserLogin();
                    userLogin.register();
                    sc.nextLine();
                    break;
                case 9:
                    PhoneValidation phoneValidation = new PhoneValidation();
                    phoneValidation.isValid123();
                    sc.nextLine();
                    break;
                default:
                    System.out.println("Wrong option,try again");
            }

            System.out.println("Do you wish to continue yes or no");
            String c = sc.nextLine();
            if(c.equalsIgnoreCase("yes"))
                continue;
            else
                System.exit(0);
        }
    }


    private static void createBooks() {
        ArrayList<Books> booksList = new ArrayList<>();
        // Static data for testing
        final Books BOOK1 = new Books( "J.K.Rowling", "Harry Potter", 123,40,"Harry","Bloomsbury Publishing",1983,"Fantasy");
        final Books BOOK2 = new Books( "Peggy Parish", "Amelia Bedelia", 567,30,"Amelia","Harper & Row",1963,"Children's picture book,comedy");
        final Books BOOK3 = new Books( "Norm Feuti", "Beak & Ally", 890,50,"Beak","HarperCollins",1981,"Comics");
        final Books BOOK4 = new Books( "Mo O'hara", "The Zombie Goldfish", 342,70,"Zombie","MacMillan",2011,"Fantasy");
        final Books BOOK5 = new Books("Ursula","A Wizard Of EarthSea",432,55,"Wizard","Parnassus",1968,"Fantasy");
        final Books BOOK6 = new Books("Micheal Dahl","Troll Hunters",987,45,"Troll","Print",2012,"Adventure");
        final Books BOOK7 = new Books("Kathryn","World Atlas",657,75,"World","Hammond",2013,"Sc-Fi");

        //adding the objects into ArrayList
        booksList.add(BOOK1);
        booksList.add(BOOK2);
        booksList.add(BOOK3);
        booksList.add(BOOK4);
        booksList.add(BOOK5);
        booksList.add(BOOK6);
        booksList.add(BOOK7);

        LibraryService libraryService = new LibraryService();
        libraryService.addBooks(booksList);


    }

    private static void createUsers() {
        ArrayList<Users> usersDetails = new ArrayList<>();
        final Users USERS1 = new Users("San123","Sanvitha","Julie","aaa","sanvi@gmail.com","Georgia,Atlanta -30909","3/02/1998",9823);
        final Users USERS2 = new Users("An142","Anvith","Lucy","bbb","Anvith@gmail.com","NewJersey,Fords - 80060","31/1/1980",9723);
        final Users USERS3 = new Users("Ka123","Kavitha","Antony","ccc","kavitha@gmail.com","California -30202","05/12/1992",9623);
        final Users USERS4 = new Users("Fe321","Sankar","Federick","abc","Sankar@gmail.com","Pennysylvania -87097","08/07/1983",9523);
        final Users USERS5 = new Users("Rich123","Kala","Richard","ddd","kala@gmail.com","Arizona - 30290","31/08/1981",98765);
        final Users USERS6 = new Users("Car123","Bala","Carl","eee","Bala@gmail.in","Florida - 20302","12/1/1985",97643);
        final Users USERS7 = new Users("Jos321","Dhandapani","Joseph","fff","Dhandapani@gmail.com","North Carolina -30405","10/11/1998",98654);

        usersDetails.add(USERS1);
        usersDetails.add(USERS2);
        usersDetails.add(USERS3);
        usersDetails.add(USERS4);
        usersDetails.add(USERS5);
        usersDetails.add(USERS6);
        usersDetails.add(USERS7);

        UserService userService = new UserService();
        userService.addUser(usersDetails);
    }

}
