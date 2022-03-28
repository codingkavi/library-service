package com.demo.librarysystem.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.SQLException;

public interface LibraryServ {
    void findBooks() throws SQLException, JsonProcessingException;
}

