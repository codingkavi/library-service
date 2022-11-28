package com.demo.librarysystem.controller;


import com.demo.librarysystem.UserService.ServiceImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/user/{lastname}")
    public void find(@PathVariable String lastname) throws SQLException {
        ServiceImpl findName = new ServiceImpl();
          findName.findByLastname(lastname);

    }

    @DeleteMapping("/user/{username}")
    public void delete(@PathVariable String username) throws SQLException {
        ServiceImpl deleteUser = new ServiceImpl();
        deleteUser.deletebyname(username);
    }
}
