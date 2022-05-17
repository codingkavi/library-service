package com.demo.librarysystem.BookService;

import com.demo.librarysystem.ServiceImplementation.GetAllBooks;
import com.demo.librarysystem.model.Books;
import com.demo.librarysystem.repository.BookRepository;
import com.demo.librarysystem.util.HibernateConfig;
import org.hibernate.Session;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;



public class LibraryServiceImpl {

    Session session;
    ResultSet resultSet;

    public LibraryServiceImpl() {

        session = HibernateConfig.getSession();
    }


    public void addBooks(ArrayList<Books> booksList) {

        Iterator<Books> itr = booksList.iterator();


        Books books;
        while (itr.hasNext()) {

            books = itr.next();
            BookRepository bookRepo = new BookRepository(books.getAuthor(), books.getTitle(), books.getIsbn(), books.getNoOfPages(), books.getKey(), books.getPublisherName(), books.getPublishedYear(), books.getGenre());
            session.beginTransaction();
            session.save(bookRepo);
            session.getTransaction().commit();
        }
    }

    public void addBook(Books book) throws SQLException {
        System.out.println(book);
        BookRepository bookRepository = new BookRepository(book.getAuthor(), book.getTitle(), book.getIsbn(), book.getNoOfPages(), book.getKey(), book.getPublisherName(), book.getPublishedYear(), book.getGenre());
        session.beginTransaction();
        session.save(bookRepository);
        session.getTransaction().commit();

    }


    /*public void findBooksWithPagination(int offset , int pageSize) throws SQLException {


    }*/
}
