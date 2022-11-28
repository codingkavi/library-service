package com.demo.librarysystem.BookService;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.SQLException;


public interface LibraryService {

    void findBooks() throws SQLException, JsonProcessingException;

}

