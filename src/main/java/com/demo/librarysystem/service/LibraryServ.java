package com.demo.librarysystem.service;

import java.sql.SQLException;

public interface LibraryServ {
    public void searchBooksbyAuthor() throws SQLException;
    public void searchBooksbyPublisher() throws SQLException;
    public void searchBooksbyTitle() throws SQLException;
    public void searchBooksbynoofPages();
    public void searchBooksbykeyword() throws SQLException;
}
