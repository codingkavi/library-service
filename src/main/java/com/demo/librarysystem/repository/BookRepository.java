package com.demo.librarysystem.repository;

import com.demo.librarysystem.model.Books;

import javax.persistence.*;
import java.util.List;

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
    @Column(name = "book_noofpages",length = 1000)
    private int noOfPages;
    @Column(name = "Publisher")
    private String publishername;
    @Column(name = "Year_Published")
    private int publishedyear;
    @Column(name = "key_search")
    private String key;
    @Column(name = "Genre")
    private String genre;




    public BookRepository(String authorName, String title, int ISBN, int noOfPages,String key, String publishername,int publishedyear,String genre){

        this.authorName = authorName;
        this.title = title;
        this.ISBN = ISBN;
        this.noOfPages = noOfPages;
        this.key = key;
        this.publishername = publishername;
        this.publishedyear = publishedyear;
        this.genre = genre;
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

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername;
    }

    public int getPublishedyear() {
        return publishedyear;
    }

    public void setPublishedyear(int publishedyear) {
        this.publishedyear = publishedyear;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "BookRepository{" +
                "bookId=" + bookId +
                ", authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", ISBN=" + ISBN +
                ", noOfPages=" + noOfPages +
                ", publishername='" + publishername + '\'' +
                ", publishedyear=" + publishedyear +
                ", key='" + key + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
