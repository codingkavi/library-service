package com.demo.librarysystem.service;

import com.demo.librarysystem.model.Books;
import com.demo.librarysystem.repository.BookRepository;
import com.demo.librarysystem.util.HibernateConfig;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.Iterator;


public class LibraryService {

    Session session;

    public LibraryService() {

        session = HibernateConfig.getSession();
    }

    public void addBooks(ArrayList<Books> booksList) {

        Iterator<Books> itr = booksList.iterator();

        while (itr.hasNext()) {

            Books books = itr.next();
            BookRepository bookRepo = new BookRepository(books.getAuthor(), books.getTitle(), books.getIsbn(), books.getNoOfPages(),books.getKey(), books.getPublishername(), books.getPublishedyear());
            session.beginTransaction();
            session.save(bookRepo);
            session.getTransaction().commit();

        }
    }
}
