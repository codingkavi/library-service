package com.demo.librarysystem.model;


public class Books {
    int bookId;
    String author;
    String title;
    String publishername;
    int publishedyear;
    int isbn;
    int noOfPages;
    String key;
    String genre;

    public Books() {}

    public Books(String author, String title, int isbn, int noOfPages,String key,String publishername, int publishedyear,String genre) {

        this.author = author;
        this.title = title;
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
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


    @Override
    public String toString() {
        return "Books{" +
                " bookId='" + bookId + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publishername='" + publishername + '\'' +
                ", publishedyear=" + publishedyear +
                ", isbn=" + isbn +
                ", noOfPages=" + noOfPages +
                ", key='" + key + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
