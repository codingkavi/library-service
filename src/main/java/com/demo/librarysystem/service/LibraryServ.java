package com.demo.librarysystem.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


public interface LibraryServ {


    void findBooks() throws SQLException, JsonProcessingException;
}

