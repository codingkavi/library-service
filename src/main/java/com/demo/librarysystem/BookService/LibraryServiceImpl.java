package com.demo.librarysystem.BookService;

import com.demo.librarysystem.model.Books;
import com.demo.librarysystem.repository.BookRepository;
import com.demo.librarysystem.util.HibernateConfig;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.Iterator;


public class LibraryServiceImpl {

    Session session;

    public LibraryServiceImpl() {

        session = HibernateConfig.getSession();
    }


    public void addBooks(ArrayList<Books> booksList) {

        Iterator<Books> itr = booksList.iterator();


        Books books;
        while (itr.hasNext()) {

            books = itr.next();
            BookRepository bookRepo = new BookRepository(books.getAuthor(), books.getTitle(), books.getIsbn(), books.getNoOfPages(), books.getKey(), books.getPublishername(), books.getPublishedyear(), books.getGenre());
            session.beginTransaction();
            session.save(bookRepo);
            session.getTransaction().commit();
        }
    }
    public Books addBook(Books book){
        System.out.println(book);
        BookRepository bookRepository = new BookRepository(book.getAuthor(), book.getTitle(), book.getIsbn(), book.getNoOfPages(), book.getKey(), book.getPublishername(), book.getPublishedyear(), book.getGenre());
        session.beginTransaction();
        session.save(bookRepository);
        session.getTransaction().commit();
        /*book.setBookId(bookRepository.getBookId());
        book.setAuthor(bookRepository.getAuthorName());
        book.setTitle(bookRepository.getTitle());
        book.setNoOfPages(bookRepository.getNoOfPages());
        book.setIsbn(bookRepository.getISBN());
        book.setGenre(bookRepository.getGenre());
        book.setKey(bookRepository.getKey());
        book.setPublishedyear(bookRepository.getPublishedyear());
        book.setPublishername(bookRepository.getPublishername());*/
        System.out.println(book);
        return book;
    }
}
