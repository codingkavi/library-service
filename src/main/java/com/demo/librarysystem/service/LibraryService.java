package com.demo.librarysystem.service;
import com.demo.librarysystem.model.Books;
import com.demo.librarysystem.repository.BookRepository;
import com.demo.librarysystem.repository.ConnectDao;
import com.demo.librarysystem.util.HibernateConfig;
import org.hibernate.Session;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LibraryService {
    Session session;

    public LibraryService() {
        session = HibernateConfig.getSession();
    }

    public void addBook(Books books) {
        BookRepository bookRepo = new BookRepository(books.getTitle(), books.getAuthor(), books.getIsbn(), books.getNoOfPages(),books.getKey(), books.getPublishername(), books.getPublishedyear());
        session.beginTransaction();
        session.save(bookRepo);
        session.getTransaction().commit();
    }

    public void addBooks(ArrayList<Books> booksList) {
        Iterator<Books> itr = booksList.iterator();
        while(itr.hasNext()) {
            Books books = itr.next();
            addBook(books);
        }
    }


    public void searchBooksbyTitle() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Title to search :");
        String bookSearch = input.nextLine();
        ConnectDao dao = new ConnectDao();
        dao.searchbyTitle(bookSearch);
    }
    public void searchBooksbyAuthor() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the author name to search :");
        String bookSearch = input.nextLine();
        ConnectDao dao = new ConnectDao();
        dao.searchbyAuthor(bookSearch);
    }
    public void searchBooksbynoofPages() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no of pages to find the book : ");
        int bookSearch = Integer.parseInt(input.nextLine());
        int input1 = Integer.parseInt(input.nextLine());
        ConnectDao dao = new ConnectDao();
        dao.searchBynoofPages(bookSearch,input1);
    }
    public void searchBooksbykeyword() throws SQLException {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the keyword to search a book : ");
        String key = input.nextLine();
        ConnectDao dao = new ConnectDao();
        dao.keySearch(key);
    }

}

