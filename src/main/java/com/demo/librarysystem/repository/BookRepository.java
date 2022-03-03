package com.demo.librarysystem.repository;

import com.demo.librarysystem.model.Book;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class BookRepository {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="seq")
    @SequenceGenerator(name="seq", sequenceName = "book_seq", initialValue=101, allocationSize=1)
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "author_name")
    private String authorName;
    @Column(name = "book_title")
    private String title;
    @Column(name = "book_ISBN")
    private int ISBN;

    public BookRepository() {

    }

    public BookRepository(String title, String authorName, int ISBN){

        this.authorName = authorName;
        this.title = title;
        this.ISBN = ISBN;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getISBN() {
        return ISBN;
    }



    @Override
    public String toString() {
        return "Book{" +
                //", bookId=" + bookId +
                ", authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", ISBN=" + ISBN +

                '}';
    }
}
