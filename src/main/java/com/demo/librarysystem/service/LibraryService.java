package com.demo.librarysystem.service;
import com.demo.librarysystem.model.Book;
import com.demo.librarysystem.model.User;
import com.demo.librarysystem.repository.BookDao;
import com.demo.librarysystem.repository.BookRepository;
import com.demo.librarysystem.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LibraryService {
    Session session;

    ArrayList<Book> bookList = new ArrayList<>();

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

    public void searchBooksbyTitle(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the input to search Records");
        String bookSearch = input.nextLine();

        BookDao dao = new BookDao();
        dao.connect(bookSearch);

//        for(Book book : bookList){
//            if(book.getTitle().contains(bookSearch)){
//                System.out.println(book.getAuthor());
//            }
//        }

    }
}

