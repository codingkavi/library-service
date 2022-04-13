package com.demo.librarysystem.Controller;


import com.demo.librarysystem.UserService.SearchUser.ServiceImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class UserController {

    @DeleteMapping("/user/{lastname}")
    public void deletebyname(@PathVariable String lastname) throws SQLException {
        ServiceImpl find = new ServiceImpl();
        find.findbyLastname(lastname);

    }
}
