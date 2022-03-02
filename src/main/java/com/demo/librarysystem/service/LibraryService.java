package com.demo.librarysystem.service;
import com.demo.librarysystem.model.Book;
import com.demo.librarysystem.model.User;
import com.demo.librarysystem.repository.BookRepository;
import com.demo.librarysystem.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;

public class LibraryService {
    Session session;

    public LibraryService() {
        session = HibernateConfig.getSession();
    }

    public void addBook(Book book) {
        BookRepository bookRepo = new BookRepository(book.getTitle(), book.getAuthor(), book.getIsbn());
        session.beginTransaction();
        session.save(bookRepo);
        session.getTransaction().commit();
    }

    public void addBooks(ArrayList<Book> bookList) {
        Iterator<Book> itr = bookList.iterator();
        while(itr.hasNext()) {
            Book book = itr.next();
            addBook(book);
        }
    }
    }

