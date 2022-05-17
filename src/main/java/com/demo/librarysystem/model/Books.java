package com.demo.librarysystem.model;


public class Books {
    int bookId;
    String author;
    String title;
    String publisherName;
    int publishedYear;
    int isbn;
    int noOfPages;
    String key;
    String genre;

    public Books() {}

    public Books(String author, String title, int isbn, int noOfPages,String key,String publisherName, int publishedYear,String genre) {

        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.noOfPages = noOfPages;
        this.key = key;
        this.publisherName = publisherName;
        this.publishedYear = publishedYear;
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

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
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
                ", publisherName='" + publisherName + '\'' +
                ", publishedYear=" + publishedYear +
                ", isbn=" + isbn +
                ", noOfPages=" + noOfPages +
                ", key='" + key + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
