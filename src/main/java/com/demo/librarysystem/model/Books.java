package com.demo.librarysystem.model;
import java.util.List;


public class Books {

    int bookId;
    String author;
    String booktitle;
    String publishername;
    int publishedyear;
    int isbn;
    int noOfPages;
    String key;
    String genre;
    List<Books> books;


    public Books() {}


    public Books(String author, String booktitle, int isbn, int noOfPages,String key,String publishername, int publishedyear,String genre) {

        this.author = author;
        this.booktitle = booktitle;
        this.isbn = isbn;
        this.noOfPages = noOfPages;
        this.key = key;
        this.publishername = publishername;
        this.publishedyear = publishedyear;
        this.genre = genre;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return booktitle;
    }

    public void setTitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }


}
